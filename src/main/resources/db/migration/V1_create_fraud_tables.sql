CREATE TABLE fraud_event (
                             event_id UUID PRIMARY KEY,
                             customer_id VARCHAR(100),
                             policy_number VARCHAR(50),
                             amount NUMERIC(19,2),
                             claim_amount NUMERIC(19,2),
                             event_date TIMESTAMP,
                             phone_number VARCHAR(20),
                             beneficiary_account VARCHAR(100),
                             policy_start_date DATE,
                             claim_date DATE,
                             payout_received BOOLEAN,
                             beneficiary_changed BOOLEAN,
                             beneficiary_change_date DATE
);