INSERT INTO c_security_permission (id, permission_label, permission_value) VALUES
('MASTER_STAFF', 'STAFF Page', 'ROLE_STAFF'),
('USER_LOGGED_IN', 'Get User Loggin Information', 'ROLE_USER_LOGGED_IN');

INSERT INTO c_security_role (id, description, name) VALUES
('ADMINISTRATOR', 'Application Administrator', 'Administrator'),
('STAFF', 'Staff', 'Staff');

INSERT INTO c_security_role_permission (id_role, id_permission) VALUES
('ADMINISTRATOR', 'USER_LOGGED_IN'),
('ADMINISTRATOR', 'MASTER_STAFF'),

('STAFF', 'USER_LOGGED_IN');


INSERT INTO c_security_user (id, active, username, id_role) VALUES
('admin', true,'admin', 'ADMINISTRATOR');

INSERT INTO c_security_user_password (id_user, password) VALUES
('admin', '$2a$08$LS3sz9Ft014MNaIGCEyt4u6VflkslOW/xosyRbinIF9.uaVLpEhB6');