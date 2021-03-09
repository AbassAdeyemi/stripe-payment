create table PAYMENTS (
  id int auto_increment primary key ,
  payment_intent_id varchar(255),
  email varchar(255)
  amount int,
  feature_request varchar(200)
);