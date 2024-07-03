CREATE TABLE exchange_value (
    id BIGINT NOT NULL,
    currency_from VARCHAR(255) NOT NULL,
    currency_to VARCHAR(255) NOT NULL,
    conversion_multiple DECIMAL(19,2) NOT NULL,
    port INTEGER NOT NULL,
    PRIMARY KEY (id)
);


