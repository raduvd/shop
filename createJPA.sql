create sequence customer_sequence start with 1000 increment by 1
create sequence location_sequence start with 1000 increment by 1
create sequence product_category_sequence start with 1000 increment by 1
create sequence product_sequence start with 1000 increment by 1
create sequence revenue_sequence start with 1000 increment by 1
create sequence shop_order_sequence start with 1000 increment by 1
create sequence supplier_sequence start with 1000 increment by 1
create table customer (id bigint not null, first_name varchar(50) not null, last_name varchar(50) not null, user_name varchar(50) not null, primary key (id))
create table location (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, name varchar(50) not null, primary key (id))
create table order_detail (order_quantity integer not null, product bigint not null, shop_order bigint not null, primary key (product, shop_order))
create table product (id bigint not null, description varchar(1000), name varchar(50) not null, price decimal(10,2) not null, weight double not null, product_category bigint not null, supplier bigint not null, primary key (id))
create table product_category (id bigint not null, description varchar(1000), name varchar(50) not null, primary key (id))
create table revenue (id bigint not null, date date, sum decimal(10,2) not null, location bigint not null, primary key (id))
create table shop_order (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, date_of_order timestamp, customer bigint not null, shipped_from_location bigint not null, primary key (id))
create table stock (quantity integer not null, location bigint not null, product bigint not null, primary key (location, product))
create table supplier (id bigint not null, name varchar(50) not null, primary key (id))
create table user (user_id bigint not null, email varchar(255), enabled boolean, password varchar(255), username varchar(255), primary key (user_id))
create table user_role (user_role_id bigint not null, role varchar(255), user bigint not null, primary key (user_role_id))
alter table order_detail add constraint FKd9sf38t1yu7b0gbcg6iyet4pv foreign key (product) references product
alter table order_detail add constraint FKro85buol3pavpykf630xebnl1 foreign key (shop_order) references shop_order
alter table product add constraint FKbvdd7owwhvkamc6unq83xdcrj foreign key (product_category) references product_category
alter table product add constraint FKhk956bj7gcdn9e2paefdt5spw foreign key (supplier) references supplier
alter table revenue add constraint FK1mu1moudlpbjvxwb26wkxw8t2 foreign key (location) references location
alter table shop_order add constraint FK71s2vudkbd2hn7m31klncdk9c foreign key (customer) references customer
alter table shop_order add constraint FKsb9avj36a2y9nw829b9fyory2 foreign key (shipped_from_location) references location
alter table stock add constraint FK3wsg6ykqr8aw8r77rsogn5jwi foreign key (location) references location
alter table stock add constraint FK2qw3dn28c2ycrur4qc7tm8u2u foreign key (product) references product
alter table user_role add constraint FKmow7bmkl6wduuutk26ypkgmm1 foreign key (user) references user
create sequence customer_sequence start with 1000 increment by 1
create sequence location_sequence start with 1000 increment by 1
create sequence product_category_sequence start with 1000 increment by 1
create sequence product_sequence start with 1000 increment by 1
create sequence revenue_sequence start with 1000 increment by 1
create sequence shop_order_sequence start with 1000 increment by 1
create sequence supplier_sequence start with 1000 increment by 1
create table customer (id bigint not null, first_name varchar(50) not null, last_name varchar(50) not null, user_name varchar(50) not null, primary key (id))
create table location (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, name varchar(50) not null, primary key (id))
create table order_detail (order_quantity integer not null, product bigint not null, shop_order bigint not null, primary key (product, shop_order))
create table product (id bigint not null, description varchar(1000), name varchar(50) not null, price decimal(10,2) not null, weight double not null, product_category bigint not null, supplier bigint not null, primary key (id))
create table product_category (id bigint not null, description varchar(1000), name varchar(50) not null, primary key (id))
create table revenue (id bigint not null, date date, sum decimal(10,2) not null, location bigint not null, primary key (id))
create table shop_order (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, date_of_order timestamp, customer bigint not null, shipped_from_location bigint not null, primary key (id))
create table stock (quantity integer not null, location bigint not null, product bigint not null, primary key (location, product))
create table supplier (id bigint not null, name varchar(50) not null, primary key (id))
create table user (user_id bigint not null, email varchar(255), enabled boolean, password varchar(255), username varchar(255), primary key (user_id))
create table user_role (user_role_id bigint not null, role varchar(255), user bigint not null, primary key (user_role_id))
alter table order_detail add constraint FKd9sf38t1yu7b0gbcg6iyet4pv foreign key (product) references product
alter table order_detail add constraint FKro85buol3pavpykf630xebnl1 foreign key (shop_order) references shop_order
alter table product add constraint FKbvdd7owwhvkamc6unq83xdcrj foreign key (product_category) references product_category
alter table product add constraint FKhk956bj7gcdn9e2paefdt5spw foreign key (supplier) references supplier
alter table revenue add constraint FK1mu1moudlpbjvxwb26wkxw8t2 foreign key (location) references location
alter table shop_order add constraint FK71s2vudkbd2hn7m31klncdk9c foreign key (customer) references customer
alter table shop_order add constraint FKsb9avj36a2y9nw829b9fyory2 foreign key (shipped_from_location) references location
alter table stock add constraint FK3wsg6ykqr8aw8r77rsogn5jwi foreign key (location) references location
alter table stock add constraint FK2qw3dn28c2ycrur4qc7tm8u2u foreign key (product) references product
alter table user_role add constraint FKmow7bmkl6wduuutk26ypkgmm1 foreign key (user) references user
create sequence customer_sequence start with 1000 increment by 1
create sequence location_sequence start with 1000 increment by 1
create sequence product_category_sequence start with 1000 increment by 1
create sequence product_sequence start with 1000 increment by 1
create sequence revenue_sequence start with 1000 increment by 1
create sequence shop_order_sequence start with 1000 increment by 1
create sequence supplier_sequence start with 1000 increment by 1
create table customer (id bigint not null, first_name varchar(50) not null, last_name varchar(50) not null, user_name varchar(50) not null, primary key (id))
create table location (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, name varchar(50) not null, primary key (id))
create table order_detail (order_quantity integer not null, product bigint not null, shop_order bigint not null, primary key (product, shop_order))
create table product (id bigint not null, description varchar(1000), name varchar(50) not null, price decimal(10,2) not null, weight double not null, product_category bigint not null, supplier bigint not null, primary key (id))
create table product_category (id bigint not null, description varchar(1000), name varchar(50) not null, primary key (id))
create table revenue (id bigint not null, date date, sum decimal(10,2) not null, location bigint not null, primary key (id))
create table shop_order (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, date_of_order timestamp, customer bigint not null, shipped_from_location bigint not null, primary key (id))
create table stock (quantity integer not null, location bigint not null, product bigint not null, primary key (location, product))
create table supplier (id bigint not null, name varchar(50) not null, primary key (id))
create table user (user_id bigint not null, email varchar(255), enabled boolean, password varchar(255), username varchar(255), primary key (user_id))
create table user_role (user_role_id bigint not null, role varchar(255), user bigint not null, primary key (user_role_id))
alter table order_detail add constraint FKd9sf38t1yu7b0gbcg6iyet4pv foreign key (product) references product
alter table order_detail add constraint FKro85buol3pavpykf630xebnl1 foreign key (shop_order) references shop_order
alter table product add constraint FKbvdd7owwhvkamc6unq83xdcrj foreign key (product_category) references product_category
alter table product add constraint FKhk956bj7gcdn9e2paefdt5spw foreign key (supplier) references supplier
alter table revenue add constraint FK1mu1moudlpbjvxwb26wkxw8t2 foreign key (location) references location
alter table shop_order add constraint FK71s2vudkbd2hn7m31klncdk9c foreign key (customer) references customer
alter table shop_order add constraint FKsb9avj36a2y9nw829b9fyory2 foreign key (shipped_from_location) references location
alter table stock add constraint FK3wsg6ykqr8aw8r77rsogn5jwi foreign key (location) references location
alter table stock add constraint FK2qw3dn28c2ycrur4qc7tm8u2u foreign key (product) references product
alter table user_role add constraint FKmow7bmkl6wduuutk26ypkgmm1 foreign key (user) references user
create sequence customer_sequence start with 1000 increment by 1
create sequence location_sequence start with 1000 increment by 1
create sequence product_category_sequence start with 1000 increment by 1
create sequence product_sequence start with 1000 increment by 1
create sequence revenue_sequence start with 1000 increment by 1
create sequence shop_order_sequence start with 1000 increment by 1
create sequence supplier_sequence start with 1000 increment by 1
create table customer (id bigint not null, first_name varchar(50) not null, last_name varchar(50) not null, user_name varchar(50) not null, primary key (id))
create table location (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, name varchar(50) not null, primary key (id))
create table order_detail (order_quantity integer not null, product bigint not null, shop_order bigint not null, primary key (product, shop_order))
create table product (id bigint not null, description varchar(1000), name varchar(50) not null, price decimal(10,2) not null, weight double not null, product_category bigint not null, supplier bigint not null, primary key (id))
create table product_category (id bigint not null, description varchar(1000), name varchar(50) not null, primary key (id))
create table revenue (id bigint not null, date date, sum decimal(10,2) not null, location bigint not null, primary key (id))
create table shop_order (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, date_of_order timestamp, customer bigint not null, shipped_from_location bigint not null, primary key (id))
create table stock (quantity integer not null, location bigint not null, product bigint not null, primary key (location, product))
create table supplier (id bigint not null, name varchar(50) not null, primary key (id))
create table user (user_id bigint not null, email varchar(255), enabled boolean, password varchar(255), username varchar(255), primary key (user_id))
create table user_role (user_role_id bigint not null, role varchar(255), user bigint not null, primary key (user_role_id))
alter table order_detail add constraint FKd9sf38t1yu7b0gbcg6iyet4pv foreign key (product) references product
alter table order_detail add constraint FKro85buol3pavpykf630xebnl1 foreign key (shop_order) references shop_order
alter table product add constraint FKbvdd7owwhvkamc6unq83xdcrj foreign key (product_category) references product_category
alter table product add constraint FKhk956bj7gcdn9e2paefdt5spw foreign key (supplier) references supplier
alter table revenue add constraint FK1mu1moudlpbjvxwb26wkxw8t2 foreign key (location) references location
alter table shop_order add constraint FK71s2vudkbd2hn7m31klncdk9c foreign key (customer) references customer
alter table shop_order add constraint FKsb9avj36a2y9nw829b9fyory2 foreign key (shipped_from_location) references location
alter table stock add constraint FK3wsg6ykqr8aw8r77rsogn5jwi foreign key (location) references location
alter table stock add constraint FK2qw3dn28c2ycrur4qc7tm8u2u foreign key (product) references product
alter table user_role add constraint FKmow7bmkl6wduuutk26ypkgmm1 foreign key (user) references user
create sequence customer_sequence start with 1000 increment by 1
create sequence location_sequence start with 1000 increment by 1
create sequence product_category_sequence start with 1000 increment by 1
create sequence product_sequence start with 1000 increment by 1
create sequence revenue_sequence start with 1000 increment by 1
create sequence shop_order_sequence start with 1000 increment by 1
create sequence supplier_sequence start with 1000 increment by 1
create table customer (id bigint not null, first_name varchar(50) not null, last_name varchar(50) not null, user_name varchar(50) not null, primary key (id))
create table location (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, name varchar(50) not null, primary key (id))
create table order_detail (order_quantity integer not null, product bigint not null, shop_order bigint not null, primary key (product, shop_order))
create table product (id bigint not null, description varchar(1000), name varchar(50) not null, price decimal(10,2) not null, weight double not null, product_category bigint not null, supplier bigint not null, primary key (id))
create table product_category (id bigint not null, description varchar(1000), name varchar(50) not null, primary key (id))
create table revenue (id bigint not null, date date, sum decimal(10,2) not null, location bigint not null, primary key (id))
create table shop_order (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, date_of_order timestamp, customer bigint not null, shipped_from_location bigint not null, primary key (id))
create table stock (quantity integer not null, location bigint not null, product bigint not null, primary key (location, product))
create table supplier (id bigint not null, name varchar(50) not null, primary key (id))
create table user (user_id bigint not null, email varchar(255), enabled boolean, password varchar(255), username varchar(255), primary key (user_id))
create table user_role (user_role_id bigint not null, role varchar(255), user bigint not null, primary key (user_role_id))
alter table order_detail add constraint FKd9sf38t1yu7b0gbcg6iyet4pv foreign key (product) references product
alter table order_detail add constraint FKro85buol3pavpykf630xebnl1 foreign key (shop_order) references shop_order
alter table product add constraint FKbvdd7owwhvkamc6unq83xdcrj foreign key (product_category) references product_category
alter table product add constraint FKhk956bj7gcdn9e2paefdt5spw foreign key (supplier) references supplier
alter table revenue add constraint FK1mu1moudlpbjvxwb26wkxw8t2 foreign key (location) references location
alter table shop_order add constraint FK71s2vudkbd2hn7m31klncdk9c foreign key (customer) references customer
alter table shop_order add constraint FKsb9avj36a2y9nw829b9fyory2 foreign key (shipped_from_location) references location
alter table stock add constraint FK3wsg6ykqr8aw8r77rsogn5jwi foreign key (location) references location
alter table stock add constraint FK2qw3dn28c2ycrur4qc7tm8u2u foreign key (product) references product
alter table user_role add constraint FKmow7bmkl6wduuutk26ypkgmm1 foreign key (user) references user
create sequence customer_sequence start with 1000 increment by 1
create sequence location_sequence start with 1000 increment by 1
create sequence product_category_sequence start with 1000 increment by 1
create sequence product_sequence start with 1000 increment by 1
create sequence revenue_sequence start with 1000 increment by 1
create sequence shop_order_sequence start with 1000 increment by 1
create sequence supplier_sequence start with 1000 increment by 1
create table customer (id bigint not null, first_name varchar(50) not null, last_name varchar(50) not null, user_name varchar(50) not null, primary key (id))
create table location (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, name varchar(50) not null, primary key (id))
create table order_detail (order_quantity integer not null, product bigint not null, shop_order bigint not null, primary key (product, shop_order))
create table product (id bigint not null, description varchar(1000), name varchar(50) not null, price decimal(10,2) not null, weight double not null, product_category bigint not null, supplier bigint not null, primary key (id))
create table product_category (id bigint not null, description varchar(1000), name varchar(50) not null, primary key (id))
create table revenue (id bigint not null, date date, sum decimal(10,2) not null, location bigint not null, primary key (id))
create table shop_order (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, date_of_order timestamp, customer bigint not null, shipped_from_location bigint not null, primary key (id))
create table stock (quantity integer not null, location bigint not null, product bigint not null, primary key (location, product))
create table supplier (id bigint not null, name varchar(50) not null, primary key (id))
create table user (user_id bigint not null, email varchar(255), enabled boolean, password varchar(255), username varchar(255), primary key (user_id))
create table user_role (user_role_id bigint not null, role varchar(255), user bigint not null, primary key (user_role_id))
alter table order_detail add constraint FKd9sf38t1yu7b0gbcg6iyet4pv foreign key (product) references product
alter table order_detail add constraint FKro85buol3pavpykf630xebnl1 foreign key (shop_order) references shop_order
alter table product add constraint FKbvdd7owwhvkamc6unq83xdcrj foreign key (product_category) references product_category
alter table product add constraint FKhk956bj7gcdn9e2paefdt5spw foreign key (supplier) references supplier
alter table revenue add constraint FK1mu1moudlpbjvxwb26wkxw8t2 foreign key (location) references location
alter table shop_order add constraint FK71s2vudkbd2hn7m31klncdk9c foreign key (customer) references customer
alter table shop_order add constraint FKsb9avj36a2y9nw829b9fyory2 foreign key (shipped_from_location) references location
alter table stock add constraint FK3wsg6ykqr8aw8r77rsogn5jwi foreign key (location) references location
alter table stock add constraint FK2qw3dn28c2ycrur4qc7tm8u2u foreign key (product) references product
alter table user_role add constraint FKmow7bmkl6wduuutk26ypkgmm1 foreign key (user) references user
create sequence customer_sequence start with 1000 increment by 1
create sequence location_sequence start with 1000 increment by 1
create sequence product_category_sequence start with 1000 increment by 1
create sequence product_sequence start with 1000 increment by 1
create sequence revenue_sequence start with 1000 increment by 1
create sequence shop_order_sequence start with 1000 increment by 1
create sequence supplier_sequence start with 1000 increment by 1
create table customer (id bigint not null, first_name varchar(50) not null, last_name varchar(50) not null, user_name varchar(50) not null, primary key (id))
create table location (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, name varchar(50) not null, primary key (id))
create table order_detail (order_quantity integer not null, product bigint not null, shop_order bigint not null, primary key (product, shop_order))
create table product (id bigint not null, description varchar(1000), name varchar(50) not null, price decimal(10,2) not null, weight double not null, product_category bigint not null, supplier bigint not null, primary key (id))
create table product_category (id bigint not null, description varchar(1000), name varchar(50) not null, primary key (id))
create table revenue (id bigint not null, date date, sum decimal(10,2) not null, location bigint not null, primary key (id))
create table shop_order (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, date_of_order timestamp, customer bigint not null, shipped_from_location bigint not null, primary key (id))
create table stock (quantity integer not null, location bigint not null, product bigint not null, primary key (location, product))
create table supplier (id bigint not null, name varchar(50) not null, primary key (id))
create table user (user_id bigint not null, email varchar(255), enabled boolean, password varchar(255), username varchar(255), primary key (user_id))
create table user_role (user_role_id bigint not null, role varchar(255), user bigint not null, primary key (user_role_id))
alter table order_detail add constraint FKd9sf38t1yu7b0gbcg6iyet4pv foreign key (product) references product
alter table order_detail add constraint FKro85buol3pavpykf630xebnl1 foreign key (shop_order) references shop_order
alter table product add constraint FKbvdd7owwhvkamc6unq83xdcrj foreign key (product_category) references product_category
alter table product add constraint FKhk956bj7gcdn9e2paefdt5spw foreign key (supplier) references supplier
alter table revenue add constraint FK1mu1moudlpbjvxwb26wkxw8t2 foreign key (location) references location
alter table shop_order add constraint FK71s2vudkbd2hn7m31klncdk9c foreign key (customer) references customer
alter table shop_order add constraint FKsb9avj36a2y9nw829b9fyory2 foreign key (shipped_from_location) references location
alter table stock add constraint FK3wsg6ykqr8aw8r77rsogn5jwi foreign key (location) references location
alter table stock add constraint FK2qw3dn28c2ycrur4qc7tm8u2u foreign key (product) references product
alter table user_role add constraint FKmow7bmkl6wduuutk26ypkgmm1 foreign key (user) references user
create sequence customer_sequence start with 1000 increment by 1
create sequence location_sequence start with 1000 increment by 1
create sequence product_category_sequence start with 1000 increment by 1
create sequence product_sequence start with 1000 increment by 1
create sequence revenue_sequence start with 1000 increment by 1
create sequence shop_order_sequence start with 1000 increment by 1
create sequence supplier_sequence start with 1000 increment by 1
create table customer (id bigint not null, first_name varchar(50) not null, last_name varchar(50) not null, user_name varchar(50) not null, primary key (id))
create table location (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, name varchar(50) not null, primary key (id))
create table order_detail (order_quantity integer not null, product bigint not null, shop_order bigint not null, primary key (product, shop_order))
create table product (id bigint not null, description varchar(1000), name varchar(50) not null, price decimal(10,2) not null, weight double not null, product_category bigint not null, supplier bigint not null, primary key (id))
create table product_category (id bigint not null, description varchar(1000), name varchar(50) not null, primary key (id))
create table revenue (id bigint not null, date date, sum decimal(10,2) not null, location bigint not null, primary key (id))
create table shop_order (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, date_of_order timestamp, customer bigint not null, shipped_from_location bigint not null, primary key (id))
create table stock (quantity integer not null, location bigint not null, product bigint not null, primary key (location, product))
create table supplier (id bigint not null, name varchar(50) not null, primary key (id))
create table user (user_id bigint not null, email varchar(255), enabled boolean, password varchar(255), username varchar(255), primary key (user_id))
create table user_role (user_role_id bigint not null, role varchar(255), user bigint not null, primary key (user_role_id))
alter table order_detail add constraint FKd9sf38t1yu7b0gbcg6iyet4pv foreign key (product) references product
alter table order_detail add constraint FKro85buol3pavpykf630xebnl1 foreign key (shop_order) references shop_order
alter table product add constraint FKbvdd7owwhvkamc6unq83xdcrj foreign key (product_category) references product_category
alter table product add constraint FKhk956bj7gcdn9e2paefdt5spw foreign key (supplier) references supplier
alter table revenue add constraint FK1mu1moudlpbjvxwb26wkxw8t2 foreign key (location) references location
alter table shop_order add constraint FK71s2vudkbd2hn7m31klncdk9c foreign key (customer) references customer
alter table shop_order add constraint FKsb9avj36a2y9nw829b9fyory2 foreign key (shipped_from_location) references location
alter table stock add constraint FK3wsg6ykqr8aw8r77rsogn5jwi foreign key (location) references location
alter table stock add constraint FK2qw3dn28c2ycrur4qc7tm8u2u foreign key (product) references product
alter table user_role add constraint FKmow7bmkl6wduuutk26ypkgmm1 foreign key (user) references user
create sequence customer_sequence start with 1000 increment by 1
create sequence location_sequence start with 1000 increment by 1
create sequence product_category_sequence start with 1000 increment by 1
create sequence product_sequence start with 1000 increment by 1
create sequence revenue_sequence start with 1000 increment by 1
create sequence shop_order_sequence start with 1000 increment by 1
create sequence supplier_sequence start with 1000 increment by 1
create table customer (id bigint not null, first_name varchar(50) not null, last_name varchar(50) not null, user_name varchar(50) not null, primary key (id))
create table location (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, name varchar(50) not null, primary key (id))
create table order_detail (order_quantity integer not null, product bigint not null, shop_order bigint not null, primary key (product, shop_order))
create table product (id bigint not null, description varchar(1000), name varchar(50) not null, price decimal(10,2) not null, weight double not null, product_category bigint not null, supplier bigint not null, primary key (id))
create table product_category (id bigint not null, description varchar(1000), name varchar(50) not null, primary key (id))
create table revenue (id bigint not null, date date, sum decimal(10,2) not null, location bigint not null, primary key (id))
create table shop_order (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, date_of_order timestamp, customer bigint not null, shipped_from_location bigint not null, primary key (id))
create table stock (quantity integer not null, location bigint not null, product bigint not null, primary key (location, product))
create table supplier (id bigint not null, name varchar(50) not null, primary key (id))
create table user (user_id bigint not null, email varchar(255), enabled boolean, password varchar(255), username varchar(255), primary key (user_id))
create table user_role (user_role_id bigint not null, role varchar(255), user bigint not null, primary key (user_role_id))
alter table order_detail add constraint FKd9sf38t1yu7b0gbcg6iyet4pv foreign key (product) references product
alter table order_detail add constraint FKro85buol3pavpykf630xebnl1 foreign key (shop_order) references shop_order
alter table product add constraint FKbvdd7owwhvkamc6unq83xdcrj foreign key (product_category) references product_category
alter table product add constraint FKhk956bj7gcdn9e2paefdt5spw foreign key (supplier) references supplier
alter table revenue add constraint FK1mu1moudlpbjvxwb26wkxw8t2 foreign key (location) references location
alter table shop_order add constraint FK71s2vudkbd2hn7m31klncdk9c foreign key (customer) references customer
alter table shop_order add constraint FKsb9avj36a2y9nw829b9fyory2 foreign key (shipped_from_location) references location
alter table stock add constraint FK3wsg6ykqr8aw8r77rsogn5jwi foreign key (location) references location
alter table stock add constraint FK2qw3dn28c2ycrur4qc7tm8u2u foreign key (product) references product
alter table user_role add constraint FKmow7bmkl6wduuutk26ypkgmm1 foreign key (user) references user
create sequence customer_sequence start with 1000 increment by 1
create sequence location_sequence start with 1000 increment by 1
create sequence product_category_sequence start with 1000 increment by 1
create sequence product_sequence start with 1000 increment by 1
create sequence revenue_sequence start with 1000 increment by 1
create sequence shop_order_sequence start with 1000 increment by 1
create sequence supplier_sequence start with 1000 increment by 1
create table customer (id bigint not null, first_name varchar(50) not null, last_name varchar(50) not null, user_name varchar(50) not null, primary key (id))
create table location (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, name varchar(50) not null, primary key (id))
create table order_detail (order_quantity integer not null, product bigint not null, shop_order bigint not null, primary key (product, shop_order))
create table product (id bigint not null, description varchar(1000), name varchar(50) not null, price decimal(10,2) not null, weight double not null, product_category bigint not null, supplier bigint not null, primary key (id))
create table product_category (id bigint not null, description varchar(1000), name varchar(50) not null, primary key (id))
create table revenue (id bigint not null, date date, sum decimal(10,2) not null, location bigint not null, primary key (id))
create table shop_order (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, date_of_order timestamp, customer bigint not null, shipped_from_location bigint not null, primary key (id))
create table stock (quantity integer not null, location bigint not null, product bigint not null, primary key (location, product))
create table supplier (id bigint not null, name varchar(50) not null, primary key (id))
create table user (user_id bigint not null, email varchar(255), enabled boolean, password varchar(255), username varchar(255), primary key (user_id))
create table user_role (user_role_id bigint not null, role varchar(255), user bigint not null, primary key (user_role_id))
alter table order_detail add constraint FKd9sf38t1yu7b0gbcg6iyet4pv foreign key (product) references product
alter table order_detail add constraint FKro85buol3pavpykf630xebnl1 foreign key (shop_order) references shop_order
alter table product add constraint FKbvdd7owwhvkamc6unq83xdcrj foreign key (product_category) references product_category
alter table product add constraint FKhk956bj7gcdn9e2paefdt5spw foreign key (supplier) references supplier
alter table revenue add constraint FK1mu1moudlpbjvxwb26wkxw8t2 foreign key (location) references location
alter table shop_order add constraint FK71s2vudkbd2hn7m31klncdk9c foreign key (customer) references customer
alter table shop_order add constraint FKsb9avj36a2y9nw829b9fyory2 foreign key (shipped_from_location) references location
alter table stock add constraint FK3wsg6ykqr8aw8r77rsogn5jwi foreign key (location) references location
alter table stock add constraint FK2qw3dn28c2ycrur4qc7tm8u2u foreign key (product) references product
alter table user_role add constraint FKmow7bmkl6wduuutk26ypkgmm1 foreign key (user) references user
create sequence customer_sequence start with 1000 increment by 1
create sequence location_sequence start with 1000 increment by 1
create sequence product_category_sequence start with 1000 increment by 1
create sequence product_sequence start with 1000 increment by 1
create sequence revenue_sequence start with 1000 increment by 1
create sequence shop_order_sequence start with 1000 increment by 1
create sequence supplier_sequence start with 1000 increment by 1
create table customer (id bigint not null, first_name varchar(50) not null, last_name varchar(50) not null, user_name varchar(50) not null, primary key (id))
create table location (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, name varchar(50) not null, primary key (id))
create table order_detail (order_quantity integer not null, product bigint not null, shop_order bigint not null, primary key (product, shop_order))
create table product (id bigint not null, description varchar(1000), name varchar(50) not null, price decimal(10,2) not null, weight double not null, product_category bigint not null, supplier bigint not null, primary key (id))
create table product_category (id bigint not null, description varchar(1000), name varchar(50) not null, primary key (id))
create table revenue (id bigint not null, date date, sum decimal(10,2) not null, location bigint not null, primary key (id))
create table shop_order (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, date_of_order timestamp, customer bigint not null, shipped_from_location bigint not null, primary key (id))
create table stock (quantity integer not null, location bigint not null, product bigint not null, primary key (location, product))
create table supplier (id bigint not null, name varchar(50) not null, primary key (id))
create table user (user_id bigint not null, email varchar(255), enabled boolean, password varchar(255), username varchar(255), primary key (user_id))
create table user_role (user_role_id bigint not null, role varchar(255), user bigint not null, primary key (user_role_id))
alter table order_detail add constraint FKd9sf38t1yu7b0gbcg6iyet4pv foreign key (product) references product
alter table order_detail add constraint FKro85buol3pavpykf630xebnl1 foreign key (shop_order) references shop_order
alter table product add constraint FKbvdd7owwhvkamc6unq83xdcrj foreign key (product_category) references product_category
alter table product add constraint FKhk956bj7gcdn9e2paefdt5spw foreign key (supplier) references supplier
alter table revenue add constraint FK1mu1moudlpbjvxwb26wkxw8t2 foreign key (location) references location
alter table shop_order add constraint FK71s2vudkbd2hn7m31klncdk9c foreign key (customer) references customer
alter table shop_order add constraint FKsb9avj36a2y9nw829b9fyory2 foreign key (shipped_from_location) references location
alter table stock add constraint FK3wsg6ykqr8aw8r77rsogn5jwi foreign key (location) references location
alter table stock add constraint FK2qw3dn28c2ycrur4qc7tm8u2u foreign key (product) references product
alter table user_role add constraint FKmow7bmkl6wduuutk26ypkgmm1 foreign key (user) references user
create sequence customer_sequence start with 1000 increment by 1
create sequence location_sequence start with 1000 increment by 1
create sequence product_category_sequence start with 1000 increment by 1
create sequence product_sequence start with 1000 increment by 1
create sequence revenue_sequence start with 1000 increment by 1
create sequence shop_order_sequence start with 1000 increment by 1
create sequence supplier_sequence start with 1000 increment by 1
create table customer (id bigint not null, first_name varchar(50) not null, last_name varchar(50) not null, user_name varchar(50) not null, primary key (id))
create table location (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, name varchar(50) not null, primary key (id))
create table order_detail (order_quantity integer not null, product bigint not null, shop_order bigint not null, primary key (product, shop_order))
create table product (id bigint not null, description varchar(1000), name varchar(50) not null, price decimal(10,2) not null, weight double not null, product_category bigint not null, supplier bigint not null, primary key (id))
create table product_category (id bigint not null, description varchar(1000), name varchar(50) not null, primary key (id))
create table revenue (id bigint not null, date date, sum decimal(10,2) not null, location bigint not null, primary key (id))
create table shop_order (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, date_of_order timestamp, customer bigint not null, shipped_from_location bigint not null, primary key (id))
create table stock (quantity integer not null, location bigint not null, product bigint not null, primary key (location, product))
create table supplier (id bigint not null, name varchar(50) not null, primary key (id))
create table user (user_id bigint not null, email varchar(255), enabled boolean, password varchar(255), username varchar(255), primary key (user_id))
create table user_role (user_role_id bigint not null, role varchar(255), user bigint not null, primary key (user_role_id))
alter table order_detail add constraint FKd9sf38t1yu7b0gbcg6iyet4pv foreign key (product) references product
alter table order_detail add constraint FKro85buol3pavpykf630xebnl1 foreign key (shop_order) references shop_order
alter table product add constraint FKbvdd7owwhvkamc6unq83xdcrj foreign key (product_category) references product_category
alter table product add constraint FKhk956bj7gcdn9e2paefdt5spw foreign key (supplier) references supplier
alter table revenue add constraint FK1mu1moudlpbjvxwb26wkxw8t2 foreign key (location) references location
alter table shop_order add constraint FK71s2vudkbd2hn7m31klncdk9c foreign key (customer) references customer
alter table shop_order add constraint FKsb9avj36a2y9nw829b9fyory2 foreign key (shipped_from_location) references location
alter table stock add constraint FK3wsg6ykqr8aw8r77rsogn5jwi foreign key (location) references location
alter table stock add constraint FK2qw3dn28c2ycrur4qc7tm8u2u foreign key (product) references product
alter table user_role add constraint FKmow7bmkl6wduuutk26ypkgmm1 foreign key (user) references user
create sequence customer_sequence start with 1000 increment by 1
create sequence location_sequence start with 1000 increment by 1
create sequence product_category_sequence start with 1000 increment by 1
create sequence product_sequence start with 1000 increment by 1
create sequence revenue_sequence start with 1000 increment by 1
create sequence shop_order_sequence start with 1000 increment by 1
create sequence supplier_sequence start with 1000 increment by 1
create table customer (id bigint not null, first_name varchar(50) not null, last_name varchar(50) not null, user_name varchar(50) not null, primary key (id))
create table location (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, name varchar(50) not null, primary key (id))
create table order_detail (order_quantity integer not null, product bigint not null, shop_order bigint not null, primary key (product, shop_order))
create table product (id bigint not null, description varchar(1000), name varchar(50) not null, price decimal(10,2) not null, weight double not null, product_category bigint not null, supplier bigint not null, primary key (id))
create table product_category (id bigint not null, description varchar(1000), name varchar(50) not null, primary key (id))
create table revenue (id bigint not null, date date, sum decimal(10,2) not null, location bigint not null, primary key (id))
create table shop_order (id bigint not null, city varchar(50), country varchar(50) not null, county varchar(50), street_address varchar(510) not null, date_of_order timestamp, customer bigint not null, shipped_from_location bigint not null, primary key (id))
create table stock (quantity integer not null, location bigint not null, product bigint not null, primary key (location, product))
create table supplier (id bigint not null, name varchar(50) not null, primary key (id))
create table user (user_id bigint not null, email varchar(255), enabled boolean, password varchar(255), username varchar(255), primary key (user_id))
create table user_role (user_role_id bigint not null, role varchar(255), user bigint not null, primary key (user_role_id))
alter table order_detail add constraint FKd9sf38t1yu7b0gbcg6iyet4pv foreign key (product) references product
alter table order_detail add constraint FKro85buol3pavpykf630xebnl1 foreign key (shop_order) references shop_order
alter table product add constraint FKbvdd7owwhvkamc6unq83xdcrj foreign key (product_category) references product_category
alter table product add constraint FKhk956bj7gcdn9e2paefdt5spw foreign key (supplier) references supplier
alter table revenue add constraint FK1mu1moudlpbjvxwb26wkxw8t2 foreign key (location) references location
alter table shop_order add constraint FK71s2vudkbd2hn7m31klncdk9c foreign key (customer) references customer
alter table shop_order add constraint FKsb9avj36a2y9nw829b9fyory2 foreign key (shipped_from_location) references location
alter table stock add constraint FK3wsg6ykqr8aw8r77rsogn5jwi foreign key (location) references location
alter table stock add constraint FK2qw3dn28c2ycrur4qc7tm8u2u foreign key (product) references product
alter table user_role add constraint FKmow7bmkl6wduuutk26ypkgmm1 foreign key (user) references user
