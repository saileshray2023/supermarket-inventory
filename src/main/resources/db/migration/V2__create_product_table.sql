CREATE TABLE product (
                         id           BIGSERIAL PRIMARY KEY,
                         name         VARCHAR(150) NOT NULL,
                         sku          VARCHAR(50) NOT NULL,
                         description  VARCHAR(500),
                         price        NUMERIC(12, 2) NOT NULL,
                         cost_price   NUMERIC(12, 2) NOT NULL,
                         category_id  BIGINT NOT NULL REFERENCES category(id),
                         active       BOOLEAN NOT NULL DEFAULT true,
                         created_at   TIMESTAMP NOT NULL DEFAULT now(),
                         updated_at   TIMESTAMP NOT NULL DEFAULT now(),

                         CONSTRAINT uq_product_sku UNIQUE (sku)
);