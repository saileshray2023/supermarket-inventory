CREATE TABLE supplier (
                          id             BIGSERIAL PRIMARY KEY,
                          name           VARCHAR(150) NOT NULL,
                          contact_person VARCHAR(150),
                          email          VARCHAR(150) NOT NULL,
                          phone          VARCHAR(20) NOT NULL,
                          address        VARCHAR(300),
                          active         BOOLEAN NOT NULL DEFAULT true,
                          created_at     TIMESTAMP NOT NULL DEFAULT now(),
                          updated_at     TIMESTAMP NOT NULL DEFAULT now(),

                          CONSTRAINT uq_supplier_email UNIQUE (email)
);