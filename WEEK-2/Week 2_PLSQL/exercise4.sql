

-- Scenario 1

DELIMITER //

CREATE FUNCTION CalculateAge(dob DATE) 
RETURNS INT
DETERMINISTIC
NO SQL
BEGIN
    DECLARE age INT;
    
    -- Calculate age based on the date of birth
    SET age = TIMESTAMPDIFF(YEAR, dob, CURDATE());
    
    RETURN age;
END;
//

DELIMITER ;
SELECT CalculateAge('1985-05-15') AS Age;
SELECT CustomerID, Name, DOB, CalculateAge(DOB) AS Age
FROM Customers
WHERE CalculateAge(DOB) > 60;


-- Scenario 2


DELIMITER //

CREATE FUNCTION CalculateMonthlyInstallment(
    loan_amount DECIMAL(15, 2),
    annual_interest_rate DECIMAL(5, 2),
    loan_duration_years INT
) 
RETURNS DECIMAL(15, 2)
DETERMINISTIC
NO SQL
BEGIN
    DECLARE monthly_interest_rate DECIMAL(5, 4);
    DECLARE number_of_payments INT;
    DECLARE monthly_installment DECIMAL(15, 2);

    -- Convert annual interest rate to monthly interest rate
    SET monthly_interest_rate = annual_interest_rate / 100 / 12;

    -- Calculate the number of payments
    SET number_of_payments = loan_duration_years * 12;

    -- Calculate the monthly installment using the formula
    IF monthly_interest_rate = 0 THEN
        SET monthly_installment = loan_amount / number_of_payments;
    ELSE
        SET monthly_installment = loan_amount * monthly_interest_rate * POWER(1 + monthly_interest_rate, number_of_payments) 
                                  / (POWER(1 + monthly_interest_rate, number_of_payments) - 1);
    END IF;

    RETURN monthly_installment;
END;
//

DELIMITER ;
SELECT CalculateMonthlyInstallment(10000, 5, 2) AS MonthlyInstallment;


-- Scenario 3
DELIMITER //

CREATE FUNCTION HasSufficientBalance(
    account_id INT,
    amount DECIMAL(10, 2)
) 
RETURNS TINYINT(1)
DETERMINISTIC
NO SQL
BEGIN
    DECLARE account_balance DECIMAL(10, 2);
    DECLARE sufficient_balance TINYINT(1);

    -- Fetch the current balance of the account
    SELECT Balance INTO account_balance
    FROM Accounts
    WHERE AccountID = account_id;

    -- Check if the balance is sufficient
    IF account_balance >= amount THEN
        SET sufficient_balance = 1; -- TRUE
    ELSE
        SET sufficient_balance = 0; -- FALSE
    END IF;

    RETURN sufficient_balance;
END;
//

DELIMITER ;
SELECT HasSufficientBalance(1, 500.00) AS IsSufficient;

