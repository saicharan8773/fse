use plsql;

-- Scenario 1
DELIMITER //

CREATE TABLE IF NOT EXISTS ErrorLog (
    LogID INT AUTO_INCREMENT PRIMARY KEY,
    ErrorMessage TEXT,
    ErrorTime DATETIME
);



-- Scenario 2
DELIMITER //

CREATE PROCEDURE SafeTransferFunds(
    IN from_account_id INT,
    IN to_account_id INT,
    IN transfer_amount DECIMAL(10, 2)
)DELIMITER //

CREATE PROCEDURE SafeTransferFunds(
    IN from_account_id INT,
    IN to_account_id INT,
    IN transfer_amount DECIMAL(10, 2)
)-- Set delimiter to //
DELIMITER //

-- Create the stored procedure
CREATE PROCEDURE SafeTransferFunds(
    IN from_account_id INT,
    IN to_account_id INT,
    IN transfer_amount DECIMAL(10, 2)
)
BEGIN
    DECLARE current_balance DECIMAL(10, 2);
    DECLARE insufficient_funds CONDITION FOR SQLSTATE '45000';
    
    -- Declare a handler for SQL exceptions
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
    BEGIN
        -- Rollback the transaction on any SQL exception
        ROLLBACK;
        -- Log the error message
        INSERT INTO ErrorLog (ErrorMessage, ErrorTime)
        VALUES (CONCAT('Transaction failed: Error occurred during fund transfer'), NOW());
    END;

    START TRANSACTION;

    -- Get the current balance of the from account
    SELECT Balance INTO current_balance
    FROM Accounts
    WHERE AccountID = from_account_id
    FOR UPDATE;

    IF current_balance < transfer_amount THEN
        -- If insufficient funds, signal an error
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Insufficient funds';
    END IF;

    -- Deduct the amount from the source account
    UPDATE Accounts
    SET Balance = Balance - transfer_amount
    WHERE AccountID = from_account_id;

    -- Add the amount to the destination account
    UPDATE Accounts
    SET Balance = Balance + transfer_amount
    WHERE AccountID = to_account_id;

    -- Commit the transaction
    COMMIT;
END;
//

-- Reset the delimiter back to ;
DELIMITER ;
-- Test valid transfer
CALL SafeTransferFunds(1, 2, 100.00);

-- Test invalid transfer (insufficient funds)
CALL SafeTransferFunds(2, 1, 1000.00);
-- Check account balances
SELECT * FROM Accounts;

-- Check error logs
SELECT * FROM ErrorLog;



CREATE TABLE IF NOT EXISTS ErrorLog (
    LogID INT AUTO_INCREMENT PRIMARY KEY,
    ErrorMessage TEXT,
    ErrorTime DATETIME
);
DELIMITER //

CREATE PROCEDURE UpdateSalary(
    IN emp_id INT,
    IN percentage DECIMAL(5, 2)
)
BEGIN
    DECLARE current_salary DECIMAL(10, 2);
    DECLARE emp_not_found CONDITION FOR SQLSTATE '02000'; -- No data found
    DECLARE CONTINUE HANDLER FOR emp_not_found
    BEGIN
        -- Rollback the transaction on error
        ROLLBACK;
        -- Log the error message
        INSERT INTO ErrorLog (ErrorMessage, ErrorTime)
        VALUES (CONCAT('Employee ID ', emp_id, ' does not exist.'), NOW());
    END;

    START TRANSACTION;

    -- Get the current salary of the employee
    SELECT Salary INTO current_salary
    FROM Employees
    WHERE EmployeeID = emp_id
    FOR UPDATE;

    -- If the employee does not exist, signal an error
    IF current_salary IS NULL THEN
        SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Employee ID does not exist';
    END IF;

    -- Update the employee's salary
    UPDATE Employees
    SET Salary = Salary * (1 + (percentage / 100))
    WHERE EmployeeID = emp_id;

    -- Commit the transaction
    COMMIT;
END;
//

DELIMITER ;
-- Assume EmployeeID 1 exists
CALL UpdateSalary(1, 10.00);  -- Increase salary by 10%
-- Assume EmployeeID 999 does not exist
CALL UpdateSalary(999, 10.00);  -- Try to increase salary by 10%
SELECT * FROM Employees;
SELECT * FROM ErrorLog;



-- Scenario 3


DELIMITER //

CREATE PROCEDURE AddNewCustomer(
    IN new_customer_id INT,
    IN new_name VARCHAR(100),
    IN new_dob DATE,
    IN new_balance DECIMAL(10, 2),
    IN new_last_modified DATE
)
BEGIN
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
    BEGIN
        -- Rollback the transaction on any SQL exception
        ROLLBACK;
        -- Log the error message
        INSERT INTO ErrorLog (ErrorMessage, ErrorTime)
        VALUES (CONCAT('Failed to insert customer with ID ', new_customer_id, ': Duplicate ID or other error'), NOW());
    END;

    START TRANSACTION;

    -- Attempt to insert the new customer
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (new_customer_id, new_name, new_dob, new_balance, new_last_modified);

    -- Commit the transaction
    COMMIT;
END;
//

DELIMITER ;


CALL AddNewCustomer(7, 'Emma Green', '1995-11-22', 2000.00, CURDATE());
CALL AddNewCustomer(1, 'Sophia White', '1988-02-14', 2500.00, CURDATE());
select * from customers;
SELECT * FROM ErrorLog;
