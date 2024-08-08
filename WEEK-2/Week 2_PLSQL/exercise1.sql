-- Scenario1
DELIMITER //

CREATE PROCEDURE ApplyDiscountToLoans()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE cur_customer_id INT;
    DECLARE cur_dob DATE;
    DECLARE cur CURSOR FOR SELECT CustomerID, DOB FROM Customers;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
    OPEN cur;
    
    read_loop: LOOP
        FETCH cur INTO cur_customer_id, cur_dob;
        IF done THEN
            LEAVE read_loop;
        END IF;
        
        -- Calculate age
        SET @age_in_years = TIMESTAMPDIFF(YEAR, cur_dob, CURDATE());
        
        -- Debug: Output fetched data
        SELECT CONCAT('CustomerID: ', cur_customer_id, ', DOB: ', cur_dob, ', Age: ', @age_in_years) AS DebugOutput;
        
        IF @age_in_years > 60 THEN
            -- Apply a 1% discount to the interest rate
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = cur_customer_id;
            
            -- Debug: Verify update
            SELECT CONCAT('Updated Loan for CustomerID: ', cur_customer_id) AS UpdateConfirmation;
        END IF;
    END LOOP;
    
    CLOSE cur;
    COMMIT; -- Commit the changes
END;
//

DELIMITER ;
CALL ApplyDiscountToLoans();
select * from loans;


-- Scenario 2
select * from customers;
ALTER TABLE Customers ADD COLUMN IsVIP BOOLEAN DEFAULT FALSE;
describe customers;
select IsVIP from customers;
DELIMITER //

CREATE PROCEDURE PromoteToVIP()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE cur_customer_id INT;
    DECLARE cur_balance DECIMAL(10, 2);
    DECLARE cur CURSOR FOR SELECT CustomerID, Balance FROM Customers;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
    OPEN cur;
    
    read_loop: LOOP
        FETCH cur INTO cur_customer_id, cur_balance;
        IF done THEN
            LEAVE read_loop;
        END IF;
        
        -- Check if balance is over $10,000 and set IsVIP flag
        IF cur_balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = TRUE
            WHERE CustomerID = cur_customer_id;
        END IF;
    END LOOP;
    
    CLOSE cur;
    COMMIT; -- Commit the changes
END;
//

DELIMITER ;
CALL PromoteToVIP();
SELECT * FROM Customers;

-- Scenario 3

DELIMITER //

CREATE PROCEDURE SendLoanReminders()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE cur_loan_id INT;
    DECLARE cur_customer_id INT;
    DECLARE cur_end_date DATE;
    DECLARE cur CURSOR FOR 
        SELECT LoanID, CustomerID, EndDate 
        FROM Loans 
        WHERE EndDate BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY);
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
    OPEN cur;
    
    read_loop: LOOP
        FETCH cur INTO cur_loan_id, cur_customer_id, cur_end_date;
        IF done THEN
            LEAVE read_loop;
        END IF;
        
        -- Print reminder message
        SELECT CONCAT('Reminder: Loan ID ', cur_loan_id, ' for Customer ID ', cur_customer_id, ' is due on ', cur_end_date, '.') AS ReminderMessage;
    END LOOP;
    
    CLOSE cur;
END;
//

DELIMITER ;
CALL SendLoanReminders();
select * from loans;