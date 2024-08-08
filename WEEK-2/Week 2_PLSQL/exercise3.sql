

-- Scenario 1


SET SQL_SAFE_UPDATES = 0;
DELIMITER //

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    -- Update all savings accounts with 1% interest
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE AccountType = 'Savings';

    -- Commit the transaction
    COMMIT;
END;
//

DELIMITER ;
CALL ProcessMonthlyInterest();
select * from Accounts;

-- Scenario 2

DELIMITER //

CREATE PROCEDURE UpdateEmployeeBonus(
    IN dept_name VARCHAR(50),
    IN bonus_percentage DECIMAL(5, 2)
)
BEGIN
    -- Update the salary by adding the bonus percentage
    UPDATE Employees
    SET Salary = Salary * (1 + bonus_percentage / 100)
    WHERE Department = dept_name;

    -- Commit the transaction
    COMMIT;
END;
//

DELIMITER ;
select * from Employees;
CALL UpdateEmployeeBonus('IT', 10.00);


-- Scenario 3

DELIMITER //

CREATE PROCEDURE TransferFunds(
    IN from_account_id INT,
    IN to_account_id INT,
    IN transfer_amount DECIMAL(10, 2)
)
BEGIN
    DECLARE current_balance DECIMAL(10, 2);
    DECLARE insufficient_funds CONDITION FOR SQLSTATE '45000';
    
    -- Start a transaction
    START TRANSACTION;
    
    -- Check the balance of the source account
    SELECT Balance INTO current_balance
    FROM Accounts
    WHERE AccountID = from_account_id
    FOR UPDATE;
    
    -- Check if the source account has sufficient funds
    IF current_balance < transfer_amount THEN
        -- Rollback and signal insufficient funds
        ROLLBACK;
        SIGNAL insufficient_funds SET MESSAGE_TEXT = 'Insufficient funds in the source account';
    ELSE
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
    END IF;
END;
//

DELIMITER ;
CALL TransferFunds(1, 2, 500.00);
SELECT * FROM Accounts;