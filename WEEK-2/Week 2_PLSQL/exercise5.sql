

-- Scenario 1

DELIMITER //

CREATE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    -- Set LastModified to the current date and time
    SET NEW.LastModified = CURDATE();
END;
//

DELIMITER ;
UPDATE Customers
SET Name = 'John Updated'
WHERE CustomerID = 1;
SELECT * FROM Customers;


CREATE TABLE IF NOT EXISTS AuditLog (
    LogID INT AUTO_INCREMENT PRIMARY KEY,
    TransactionID INT,
    AccountID INT,
    TransactionDate DATE,
    Amount DECIMAL(10, 2),
    TransactionType VARCHAR(10),
    LogTimestamp DATETIME
);


-- Scenario 2
DELIMITER //

CREATE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    -- Insert a record into the AuditLog table
    INSERT INTO AuditLog (TransactionID, AccountID, TransactionDate, Amount, TransactionType, LogTimestamp)
    VALUES (NEW.TransactionID, NEW.AccountID, NEW.TransactionDate, NEW.Amount, NEW.TransactionType, NOW());
END;
//

DELIMITER ;
SELECT * FROM AuditLog;


-- Scenario 3

DELIMITER //

CREATE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
BEGIN
    DECLARE current_balance DECIMAL(10, 2);
    
    -- Get the current balance of the account
    SELECT Balance INTO current_balance
    FROM Accounts
    WHERE AccountID = NEW.AccountID;

    -- Check rules for withdrawals
    IF NEW.TransactionType = 'Withdrawal' THEN
        IF NEW.Amount > current_balance THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Insufficient funds for withdrawal';
        END IF;
    END IF;

    -- Check rules for deposits
    IF NEW.TransactionType = 'Deposit' THEN
        IF NEW.Amount <= 0 THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Deposit amount must be positive';
        END IF;
    END IF;
END;
//

DELIMITER ;
SELECT * FROM Transactions;