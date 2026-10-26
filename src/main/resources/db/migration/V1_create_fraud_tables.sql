CREATE TABLE fraud_event (
                             event_id UUID PRIMARY KEY,
                             customer_id VARCHAR(100),
                             policy_number VARCHAR(50),
                             amount NUMERIC(19,2),
                             event_date TIMESTAMP
);