-- Table01: accounts

-- DROP TABLE accounts;

CREATE TABLE accounts
(
  guid character varying(32) NOT NULL,
  name character varying(2048) NOT NULL,
  account_type character varying(2048) NOT NULL,
  commodity_guid character varying(32),
  commodity_scu integer NOT NULL,
  non_std_scu integer NOT NULL,
  parent_guid character varying(32),
  code character varying(2048),
  description character varying(2048),
  hidden integer,
  placeholder integer,
  CONSTRAINT accounts_pkey PRIMARY KEY (guid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE accounts
  OWNER TO postgres;

-- Table02: billterms

-- DROP TABLE billterms;

CREATE TABLE billterms
(
  guid character varying(32) NOT NULL,
  name character varying(2048) NOT NULL,
  description character varying(2048) NOT NULL,
  refcount integer NOT NULL,
  invisible integer NOT NULL,
  parent character varying(32),
  type character varying(2048) NOT NULL,
  duedays integer,
  discountdays integer,
  discount_num bigint,
  discount_denom bigint,
  cutoff integer,
  CONSTRAINT billterms_pkey PRIMARY KEY (guid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE billterms
  OWNER TO postgres;

-- Table: books

-- DROP TABLE03 books;

CREATE TABLE books
(
  guid character varying(32) NOT NULL,
  root_account_guid character varying(32) NOT NULL,
  root_template_guid character varying(32) NOT NULL,
  CONSTRAINT books_pkey PRIMARY KEY (guid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE books
  OWNER TO postgres;

-- Table04: budget_amounts

-- DROP TABLE budget_amounts;

CREATE TABLE budget_amounts
(
  id serial NOT NULL,
  budget_guid character varying(32) NOT NULL,
  account_guid character varying(32) NOT NULL,
  period_num integer NOT NULL,
  amount_num bigint NOT NULL,
  amount_denom bigint NOT NULL,
  CONSTRAINT budget_amounts_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE budget_amounts
  OWNER TO postgres;

-- Table05: budgets

-- DROP TABLE budgets;

CREATE TABLE budgets
(
  guid character varying(32) NOT NULL,
  name character varying(2048) NOT NULL,
  description character varying(2048),
  num_periods integer NOT NULL,
  CONSTRAINT budgets_pkey PRIMARY KEY (guid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE budgets
  OWNER TO postgres;

-- Table06: commodities

-- DROP TABLE commodities;

CREATE TABLE commodities
(
  guid character varying(32) NOT NULL,
  namespace character varying(2048) NOT NULL,
  mnemonic character varying(2048) NOT NULL,
  fullname character varying(2048),
  cusip character varying(2048),
  fraction integer NOT NULL,
  quote_flag integer NOT NULL,
  quote_source character varying(2048),
  quote_tz character varying(2048),
  CONSTRAINT commodities_pkey PRIMARY KEY (guid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE commodities
  OWNER TO postgres;

-- Table07: customers

-- DROP TABLE customers;

CREATE TABLE customers
(
  guid character varying(32) NOT NULL,
  name character varying(2048) NOT NULL,
  id character varying(2048) NOT NULL,
  notes character varying(2048) NOT NULL,
  active integer NOT NULL,
  discount_num bigint NOT NULL,
  discount_denom bigint NOT NULL,
  credit_num bigint NOT NULL,
  credit_denom bigint NOT NULL,
  currency character varying(32) NOT NULL,
  tax_override integer NOT NULL,
  addr_name character varying(1024),
  addr_addr1 character varying(1024),
  addr_addr2 character varying(1024),
  addr_addr3 character varying(1024),
  addr_addr4 character varying(1024),
  addr_phone character varying(128),
  addr_fax character varying(128),
  addr_email character varying(256),
  shipaddr_name character varying(1024),
  shipaddr_addr1 character varying(1024),
  shipaddr_addr2 character varying(1024),
  shipaddr_addr3 character varying(1024),
  shipaddr_addr4 character varying(1024),
  shipaddr_phone character varying(128),
  shipaddr_fax character varying(128),
  shipaddr_email character varying(256),
  terms character varying(32),
  tax_included integer,
  taxtable character varying(32),
  CONSTRAINT customers_pkey PRIMARY KEY (guid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE customers
  OWNER TO postgres;

-- Table08: employees

-- DROP TABLE employees;

CREATE TABLE employees
(
  guid character varying(32) NOT NULL,
  username character varying(2048) NOT NULL,
  id character varying(2048) NOT NULL,
  language character varying(2048) NOT NULL,
  acl character varying(2048) NOT NULL,
  active integer NOT NULL,
  currency character varying(32) NOT NULL,
  ccard_guid character varying(32),
  workday_num bigint NOT NULL,
  workday_denom bigint NOT NULL,
  rate_num bigint NOT NULL,
  rate_denom bigint NOT NULL,
  addr_name character varying(1024),
  addr_addr1 character varying(1024),
  addr_addr2 character varying(1024),
  addr_addr3 character varying(1024),
  addr_addr4 character varying(1024),
  addr_phone character varying(128),
  addr_fax character varying(128),
  addr_email character varying(256),
  CONSTRAINT employees_pkey PRIMARY KEY (guid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE employees
  OWNER TO postgres;

-- Table09: entries

-- DROP TABLE entries;

CREATE TABLE entries
(
  guid character varying(32) NOT NULL,
  date timestamp without time zone NOT NULL,
  date_entered timestamp without time zone,
  description character varying(2048),
  action character varying(2048),
  notes character varying(2048),
  quantity_num bigint,
  quantity_denom bigint,
  i_acct character varying(32),
  i_price_num bigint,
  i_price_denom bigint,
  i_discount_num bigint,
  i_discount_denom bigint,
  invoice character varying(32),
  i_disc_type character varying(2048),
  i_disc_how character varying(2048),
  i_taxable integer,
  i_taxincluded integer,
  i_taxtable character varying(32),
  b_acct character varying(32),
  b_price_num bigint,
  b_price_denom bigint,
  bill character varying(32),
  b_taxable integer,
  b_taxincluded integer,
  b_taxtable character varying(32),
  b_paytype integer,
  billable integer,
  billto_type integer,
  billto_guid character varying(32),
  order_guid character varying(32),
  CONSTRAINT entries_pkey PRIMARY KEY (guid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE entries
  OWNER TO postgres;

-- Table10: gnclock

-- DROP TABLE gnclock;

CREATE TABLE gnclock
(
  hostname character varying(255),
  pid integer
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gnclock
  OWNER TO postgres;

-- Table11: invoices

-- DROP TABLE invoices;

CREATE TABLE invoices
(
  guid character varying(32) NOT NULL,
  id character varying(2048) NOT NULL,
  date_opened timestamp without time zone,
  date_posted timestamp without time zone,
  notes character varying(2048) NOT NULL,
  active integer NOT NULL,
  currency character varying(32) NOT NULL,
  owner_type integer,
  owner_guid character varying(32),
  terms character varying(32),
  billing_id character varying(2048),
  post_txn character varying(32),
  post_lot character varying(32),
  post_acc character varying(32),
  billto_type integer,
  billto_guid character varying(32),
  charge_amt_num bigint,
  charge_amt_denom bigint,
  CONSTRAINT invoices_pkey PRIMARY KEY (guid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE invoices
  OWNER TO postgres;

-- Table12: jobs

-- DROP TABLE jobs;

CREATE TABLE jobs
(
  guid character varying(32) NOT NULL,
  id character varying(2048) NOT NULL,
  name character varying(2048) NOT NULL,
  reference character varying(2048) NOT NULL,
  active integer NOT NULL,
  owner_type integer,
  owner_guid character varying(32),
  CONSTRAINT jobs_pkey PRIMARY KEY (guid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE jobs
  OWNER TO postgres;

-- Table13: lots

-- DROP TABLE lots;

CREATE TABLE lots
(
  guid character varying(32) NOT NULL,
  account_guid character varying(32),
  is_closed integer NOT NULL,
  CONSTRAINT lots_pkey PRIMARY KEY (guid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE lots
  OWNER TO postgres;

-- Table14: orders

-- DROP TABLE orders;

CREATE TABLE orders
(
  guid character varying(32) NOT NULL,
  id character varying(2048) NOT NULL,
  notes character varying(2048) NOT NULL,
  reference character varying(2048) NOT NULL,
  active integer NOT NULL,
  date_opened timestamp without time zone NOT NULL,
  date_closed timestamp without time zone NOT NULL,
  owner_type integer NOT NULL,
  owner_guid character varying(32) NOT NULL,
  CONSTRAINT orders_pkey PRIMARY KEY (guid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE orders
  OWNER TO postgres;

-- Table15: prices

-- DROP TABLE prices;

CREATE TABLE prices
(
  guid character varying(32) NOT NULL,
  commodity_guid character varying(32) NOT NULL,
  currency_guid character varying(32) NOT NULL,
  date timestamp without time zone NOT NULL,
  source character varying(2048),
  type character varying(2048),
  value_num bigint NOT NULL,
  value_denom bigint NOT NULL,
  CONSTRAINT prices_pkey PRIMARY KEY (guid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE prices
  OWNER TO postgres;

-- Table16: recurrences

-- DROP TABLE recurrences;

CREATE TABLE recurrences
(
  id serial NOT NULL,
  obj_guid character varying(32) NOT NULL,
  recurrence_mult integer NOT NULL,
  recurrence_period_type character varying(2048) NOT NULL,
  recurrence_period_start date NOT NULL,
  recurrence_weekend_adjust character varying(2048) NOT NULL,
  CONSTRAINT recurrences_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE recurrences
  OWNER TO postgres;

-- Table17: schedxactions

-- DROP TABLE schedxactions;

CREATE TABLE schedxactions
(
  guid character varying(32) NOT NULL,
  name character varying(2048),
  enabled integer NOT NULL,
  start_date date,
  end_date date,
  last_occur date,
  num_occur integer NOT NULL,
  rem_occur integer NOT NULL,
  auto_create integer NOT NULL,
  auto_notify integer NOT NULL,
  adv_creation integer NOT NULL,
  adv_notify integer NOT NULL,
  instance_count integer NOT NULL,
  template_act_guid character varying(32) NOT NULL,
  CONSTRAINT schedxactions_pkey PRIMARY KEY (guid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE schedxactions
  OWNER TO postgres;

-- Table18: slots

-- DROP TABLE slots;

CREATE TABLE slots
(
  id serial NOT NULL,
  obj_guid character varying(32) NOT NULL,
  name character varying(4096) NOT NULL,
  slot_type integer NOT NULL,
  int64_val bigint,
  string_val character varying(4096),
  double_val double precision,
  timespec_val timestamp without time zone,
  guid_val character varying(32),
  numeric_val_num bigint,
  numeric_val_denom bigint,
  gdate_val date,
  CONSTRAINT slots_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE slots
  OWNER TO postgres;

-- Index: slots_guid_index

-- DROP INDEX slots_guid_index;

CREATE INDEX slots_guid_index
  ON slots
  USING btree
  (obj_guid COLLATE pg_catalog."default");

-- Table19: splits

-- DROP TABLE splits;

CREATE TABLE splits
(
  guid character varying(32) NOT NULL,
  tx_guid character varying(32) NOT NULL,
  account_guid character varying(32) NOT NULL,
  memo character varying(2048) NOT NULL,
  action character varying(2048) NOT NULL,
  reconcile_state character varying(1) NOT NULL,
  reconcile_date timestamp without time zone,
  value_num bigint NOT NULL,
  value_denom bigint NOT NULL,
  quantity_num bigint NOT NULL,
  quantity_denom bigint NOT NULL,
  lot_guid character varying(32),
  CONSTRAINT splits_pkey PRIMARY KEY (guid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE splits
  OWNER TO postgres;

-- Index: splits_account_guid_index

-- DROP INDEX splits_account_guid_index;

CREATE INDEX splits_account_guid_index
  ON splits
  USING btree
  (account_guid COLLATE pg_catalog."default");

-- Index: splits_tx_guid_index

-- DROP INDEX splits_tx_guid_index;

CREATE INDEX splits_tx_guid_index
  ON splits
  USING btree
  (tx_guid COLLATE pg_catalog."default");

-- Table20: taxtable_entries

-- DROP TABLE taxtable_entries;

CREATE TABLE taxtable_entries
(
  id serial NOT NULL,
  taxtable character varying(32) NOT NULL,
  account character varying(32) NOT NULL,
  amount_num bigint NOT NULL,
  amount_denom bigint NOT NULL,
  type integer NOT NULL,
  CONSTRAINT taxtable_entries_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE taxtable_entries
  OWNER TO postgres;

-- Table21: taxtables

-- DROP TABLE taxtables;

CREATE TABLE taxtables
(
  guid character varying(32) NOT NULL,
  name character varying(50) NOT NULL,
  refcount bigint NOT NULL,
  invisible integer NOT NULL,
  parent character varying(32),
  CONSTRAINT taxtables_pkey PRIMARY KEY (guid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE taxtables
  OWNER TO postgres;

-- Table22: transactions

-- DROP TABLE transactions;

CREATE TABLE transactions
(
  guid character varying(32) NOT NULL,
  currency_guid character varying(32) NOT NULL,
  num character varying(2048) NOT NULL,
  post_date timestamp without time zone,
  enter_date timestamp without time zone,
  description character varying(2048),
  CONSTRAINT transactions_pkey PRIMARY KEY (guid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE transactions
  OWNER TO postgres;

-- Index: tx_post_date_index

-- DROP INDEX tx_post_date_index;

CREATE INDEX tx_post_date_index
  ON transactions
  USING btree
  (post_date);

-- Table23: vendors

-- DROP TABLE vendors;

CREATE TABLE vendors
(
  guid character varying(32) NOT NULL,
  name character varying(2048) NOT NULL,
  id character varying(2048) NOT NULL,
  notes character varying(2048) NOT NULL,
  currency character varying(32) NOT NULL,
  active integer NOT NULL,
  tax_override integer NOT NULL,
  addr_name character varying(1024),
  addr_addr1 character varying(1024),
  addr_addr2 character varying(1024),
  addr_addr3 character varying(1024),
  addr_addr4 character varying(1024),
  addr_phone character varying(128),
  addr_fax character varying(128),
  addr_email character varying(256),
  terms character varying(32),
  tax_inc character varying(2048),
  tax_table character varying(32),
  CONSTRAINT vendors_pkey PRIMARY KEY (guid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE vendors
  OWNER TO postgres;

-- Table24: versions

-- DROP TABLE versions;

CREATE TABLE versions
(
  table_name character varying(50) NOT NULL,
  table_version integer NOT NULL,
  CONSTRAINT versions_pkey PRIMARY KEY (table_name)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE versions
  OWNER TO postgres;

