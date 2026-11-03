CREATE TABLE funds_hold (
                            hold_id VARCHAR(36) PRIMARY KEY,
                            customer_id VARCHAR(100),
                            amount NUMERIC(19,2),
                            hold_reason VARCHAR(255),
                            hold_period_hours INTEGER,
                            created_date TIMESTAMP
);