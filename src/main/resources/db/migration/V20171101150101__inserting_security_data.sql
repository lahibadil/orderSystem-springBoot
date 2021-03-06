-- password is 'password'
INSERT INTO account (id, username, password, email,enabled, credentialsexpired, expired, locked, version, createdBy, createdAt, updatedBy, updatedAt) VALUES (1, 'user', '$2a$10$9/44Rne7kQqPXa0cY6NfG.3XzScMrCxFYjapoLq/wFmHz7EC9praK', 'orders.user@mailinator.com',true, false, false, false, 0, 'user', NOW(), NULL, NULL);
-- password is 'operations'
INSERT INTO account (id, username, password, email, enabled, credentialsexpired, expired, locked, version, createdBy, createdAt, updatedBy, updatedAt) VALUES (2, 'operations', '$2a$10$CoMVfutnv1qZ.fNlHY1Na.rteiJhsDF0jB1o.76qXcfdWN6As27Zm', 'orders.ops@mailinator.com',true, false, false, false, 0, 'user', NOW(), NULL, NULL);

INSERT INTO role (id, code, label, ordinal, effectiveAt, expiresAt, createdAt) VALUES (1, 'ROLE_USER', 'User', 0, NOW(), NULL, NOW());
INSERT INTO role (id, code, label, ordinal, effectiveAt, expiresAt, createdAt) VALUES (2, 'ROLE_ADMIN', 'Admin', 1, NOW(), NULL, NOW());
INSERT INTO role (id, code, label, ordinal, effectiveAt, expiresAt, createdAt) VALUES (3, 'ROLE_SYSADMIN', 'System Admin', 2, NOW(), NULL, NOW());

INSERT INTO account_role (account_id, role_id) SELECT a.id, r.id FROM Account a, Role r WHERE a.username = 'user' and r.id = 1;
INSERT INTO account_role (account_id, role_id) SELECT a.id, r.id FROM Account a, Role r WHERE a.username = 'operations' and r.id = 3;