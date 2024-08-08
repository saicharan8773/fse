

-- Scenario 1

DELIMITER //

CREATE PROCEDURE GenerateMonthlyStatements()
BEGIN
    -- Declare variables
    DECLARE done INT DEFAULT FALSE;
    DECLARE v_customer_id INT;
    DECLARE v_name VARCHAR(100);
    DECLARE v_transaction_date DATE;
    DECLARE v_amount DECIMAL(10, 2);
    DECLARE v_transaction_type VARCHAR(10);

    -- Define the cursor for fetching transactions for the current month
    DECLARE cur_monthly_statements CURSOR FOR
        SELECT 
            c.CustomerID,
            c.Name,
            t.TransactionDate,
            t.Amount,
            t.TransactionType
        FROM 
            Customers c
        JOIN 
            Accounts a ON c.CustomerID = a.CustomerID
        JOIN 
            Transactions t ON a.AccountID = t.AccountID
        WHERE 
            t.TransactionDate BETWEEN DATE_FORMAT(CURDATE(), '%Y-%m-01') AND LAST_DAY(CURDATE());

    -- Define the handler for no data
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    -- Open the cursor
    OPEN cur_monthly_statements;

    -- Loop through the results
    read_loop: LOOP
        FETCH cur_monthly_statements INTO v_customer_id, v_name, v_transaction_date, v_amount, v_transaction_type;
        IF done THEN
            LEAVE read_loop;
        END IF;

        -- Print the statement for each customer
        SELECT 
            CONCAT('Customer ID: ', v_customer_id) AS CustomerInfo,
            CONCAT('Name: ', v_name) AS CustomerName,
            CONCAT('Transaction Date: ', v_transaction_date) AS TransactionDate,
            CONCAT('Amount: ', v_amount) AS TransactionAmount,
            CONCAT('Transaction Type: ', v_transaction_type) AS TransactionType;

    END LOOP;

    -- Close the cursor
    CLOSE cur_monthly_statements;
END;
//

DELIMITER ;
CALL GenerateMonthlyStatements();
select * from customers;



-- Scenario 2

CREATE DEFINER=`root`@`localhost` PROCEDURE `ApplyAnnualFee`(p_fee DECIMAL(10, 2))
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE cur_account_id INT;
    DECLARE cur_balance DECIMAL(10, 2);

    DECLARE cur1 CURSOR FOR 
        SELECT AccountID, Balance 
        FROM Accounts;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur1;

    read_loop: LOOP
        FETCH cur1 INTO cur_account_id, cur_balance;
        IF done THEN
            LEAVE read_loop;
        END IF;


        SET cur_balance = cur_balance - p_fee;


        UPDATE Accounts
        SET Balance = cur_balance
        WHERE AccountID = cur_account_id;
    END LOOP;

    CLOSE cur1;
    COMMIT;
END

-- Scenario 3
DELIMITER //

CREATE PROCEDURE UpdateLoanInterestRates()
BEGIN
    -- Declare variables to hold fetched data
    DECLARE v_loan_id INT;
    DECLARE v_interest_rate DECIMAL(5, 2);
    DECLARE done BOOLEAN DEFAULT FALSE;
    
    -- Declare the cursor for fetching all loans
    DECLARE cur_loans CURSOR FOR
        SELECT LoanID, InterestRate
        FROM Loans;
        
    -- Declare a handler for the end of the cursor
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    -- Open the cursor
    OPEN cur_loans;
    
    -- Fetch and process each loan
    read_loop: LOOP
        FETCH cur_loans INTO v_loan_id, v_interest_rate;
        IF done THEN
            LEAVE read_loop;
        END IF;
        
        -- Update the interest rate based on the new policy
        UPDATE Loans
        SET InterestRate = v_interest_rate + 0.50
        WHERE LoanID = v_loan_id;
    END LOOP;
    
    -- Close the cursor
    CLOSE cur_loans;
    
    -- Commit the transaction
    COMMIT;
END;
//

DELIMITER ;

CALL UpdateLoanInterestRates();
SELECT * FROM Loans;