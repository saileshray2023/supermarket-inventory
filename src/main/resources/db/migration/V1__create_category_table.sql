CREATE TABLE category (
                          id          BIGSERIAL PRIMARY KEY,
                          name        VARCHAR(100) NOT NULL,
                          description VARCHAR(500),
                          created_at  TIMESTAMP NOT NULL DEFAULT now(),
                          updated_at  TIMESTAMP NOT NULL DEFAULT now(),

                          CONSTRAINT uq_category_name UNIQUE (name)
);