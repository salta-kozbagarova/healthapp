-- inserting users
INSERT INTO users (id, email, username, password) values(nextval ('users_id_seq'), 'admin@gmail.com', 'admin', '$2a$06$6n2RD7QxapaxJQ7hlIVAoOcZVFxoEpaR4g8ekNqKRcK2Bus70z3oe')
INSERT INTO users (id, email, username, password) values(nextval ('users_id_seq'), 'student@gmail.com', 'student', '$2a$06$mHh2KEcWmIVw9p3jT9VUbuo4/YaWOvk3dX7Vk2ZNfVTeSou1Gs6py')
INSERT INTO users (id, email, username, password) values(nextval ('users_id_seq'), 'demo1@gmail.com', 'demo1', '$2a$06$mHh2KEcWmIVw9p3jT9VUbuo4/YaWOvk3dX7Vk2ZNfVTeSou1Gs6py')
INSERT INTO users (id, email, username, password) values(nextval ('users_id_seq'), 'demo2@gmail.com', 'demo2', '$2a$06$mHh2KEcWmIVw9p3jT9VUbuo4/YaWOvk3dX7Vk2ZNfVTeSou1Gs6py')
INSERT INTO users (id, email, username, password) values(nextval ('users_id_seq'), 'demo3@gmail.com', 'demo3', '$2a$06$mHh2KEcWmIVw9p3jT9VUbuo4/YaWOvk3dX7Vk2ZNfVTeSou1Gs6py')
INSERT INTO users (id, email, username, password) values(nextval ('users_id_seq'), 'demo4@gmail.com', 'demo4', '$2a$06$mHh2KEcWmIVw9p3jT9VUbuo4/YaWOvk3dX7Vk2ZNfVTeSou1Gs6py')
INSERT INTO users (id, email, username, password) values(nextval ('users_id_seq'), 'demo5@gmail.com', 'demo5', '$2a$06$mHh2KEcWmIVw9p3jT9VUbuo4/YaWOvk3dX7Vk2ZNfVTeSou1Gs6py')
INSERT INTO users (id, email, username, password) values(nextval ('users_id_seq'), 'demo6@gmail.com', 'demo6', '$2a$06$mHh2KEcWmIVw9p3jT9VUbuo4/YaWOvk3dX7Vk2ZNfVTeSou1Gs6py')
INSERT INTO users (id, email, username, password) values(nextval ('users_id_seq'), 'demo7@gmail.com', 'demo7', '$2a$06$mHh2KEcWmIVw9p3jT9VUbuo4/YaWOvk3dX7Vk2ZNfVTeSou1Gs6py')
INSERT INTO users (id, email, username, password) values(nextval ('users_id_seq'), 'demo8@gmail.com', 'demo8', '$2a$06$mHh2KEcWmIVw9p3jT9VUbuo4/YaWOvk3dX7Vk2ZNfVTeSou1Gs6py')
-- inserting roles
INSERT INTO roles (id, name) values(nextval ('roles_id_seq'), 'ROLE_USER')
INSERT INTO roles (id, name) values(nextval ('roles_id_seq'), 'ROLE_ADMIN')
-- inserting user_roles
INSERT INTO user_roles (user_id,role_id) values(1, 2)
INSERT INTO user_roles (user_id,role_id) values(2, 1)
INSERT INTO user_roles (user_id,role_id) values(3, 1)
INSERT INTO user_roles (user_id,role_id) values(4, 1)
INSERT INTO user_roles (user_id,role_id) values(5, 1)
INSERT INTO user_roles (user_id,role_id) values(6, 1)
INSERT INTO user_roles (user_id,role_id) values(7, 1)
INSERT INTO user_roles (user_id,role_id) values(8, 1)
INSERT INTO user_roles (user_id,role_id) values(9, 1)
INSERT INTO user_roles (user_id,role_id) values(10, 1)

--inserting drugstore_rating
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, null, 4, 2)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 3, 2, 9, 2)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 3, 5, 16, 2)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 5, 23, 2)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 4, 28, 2)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), null, 3, 30, 2)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 4, 35, 2)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 5, 47, 2)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 2, 3, 4, 3)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 4, 5, 9, 3)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 5, 11, 3)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 3, null, 16, 3)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 5, 23, 3)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 2, 5, 28, 3)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 4, null, 30, 3)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 4, 4, 47, 3)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), null, 3, 4, 4)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 4, 5, 9, 4)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 5, 11, 4)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 4, 3, 23, 4)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 5, 28, 4)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 2, 5, 30, 4)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), null, 5, 35, 4)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, null, 42, 4)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 5, 47, 4)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 4, 4, 5)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 3, 2, 9, 5)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 1, 5, 11, 5)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 3, 5, 16, 5)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, null, 23, 5)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 4, 35, 5)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), null, 5, 42, 5)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 5, 47, 5)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 2, 3, 4, 6)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 4, null, 9, 6)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 3, 5, 16, 6)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 5, 23, 6)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 2, 5, 28, 6)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 4, null, 47, 6)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 3, 4, 7)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 4, 5, 9, 7)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 4, 3, 23, 7)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 5, 28, 7)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 2, 5, 30, 7)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 5, 42, 7)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 5, 47, 7)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 4, 4, 8)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 3, 2, 9, 8)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 1, 5, 11, 8)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 3, 5, 16, 8)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 5, 23, 8)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 4, 28, 8)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 2, 3, 30, 8)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 4, 35, 8)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 3, 5, 42, 8)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), null, 4, 47, 8)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 2, 3, 4, 9)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 4, 5, 9, 9)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 5, 11, 9)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 3, 5, 16, 9)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 5, 5, 23, 9)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 2, 5, 28, 9)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 3, 2, 42, 9)
INSERT INTO drugstore_rating (id, price, drugs_availability, drugstore_id, user_id) values(nextval ('drugstore_rating_id_seq'), 4, 4, 47, 9)

-- inserting into hospital_rating
INSERT INTO hospital_rating (id, price, service, hospital_id, user_id) values(nextval ('hospital_rating_id_seq'), null, 4, 4, 2)
INSERT INTO hospital_rating (id, price, service, hospital_id, user_id) values(nextval ('hospital_rating_id_seq'), 5, 5, 9, 2)
INSERT INTO hospital_rating (id, price, service, hospital_id, user_id) values(nextval ('hospital_rating_id_seq'), 5, null, 11, 2)
INSERT INTO hospital_rating (id, price, service, hospital_id, user_id) values(nextval ('hospital_rating_id_seq'), 2, 3, 5, 2)
INSERT INTO hospital_rating (id, price, service, hospital_id, user_id) values(nextval ('hospital_rating_id_seq'), 5, 5, 12, 2)
INSERT INTO hospital_rating (id, price, service, hospital_id, user_id) values(nextval ('hospital_rating_id_seq'), 5, 3, 1, 2)
INSERT INTO hospital_rating (id, price, service, hospital_id, user_id) values(nextval ('hospital_rating_id_seq'), 4, 4, 6, 2)
INSERT INTO hospital_rating (id, price, service, hospital_id, user_id) values(nextval ('hospital_rating_id_seq'), 5, 4, 13, 2)
INSERT INTO hospital_rating (id, price, service, hospital_id, user_id) values(nextval ('hospital_rating_id_seq'), 4, 4, 2, 2)
INSERT INTO hospital_rating (id, price, service, hospital_id, user_id) values(nextval ('hospital_rating_id_seq'), 5, 5, 7, 2)
INSERT INTO hospital_rating (id, price, service, hospital_id, user_id) values(nextval ('hospital_rating_id_seq'), null, 4, 4, 3)

-- inserting into drugstore_comment
INSERT INTO drugstore_comment (id, comment, "date", drugstore_id, user_id) values(nextval ('drugstore_comment_id_seq'), '��� �����-"����", ����� ������������ � ������ � ���-�������. Lorem Ipsum �������� ����������� "�����" ��� ������� �� �������� � ������ XVI ����.',  now()::timestamp, 4, 2)
INSERT INTO drugstore_comment (id, comment, "date", drugstore_id, user_id) values(nextval ('drugstore_comment_id_seq'), '������������ �������� ����������, ��� ������ ������������ ������ �� ������������ ������� ������������ �������� ����� (������������) ������� � ������������ ����� �����������. � ������ ������� ���������� �������������-���������������� ����������� ����� ������������ ��������� ��������� ������ ������� �� ���������� ������ ��������. ������ �����������, � ����������� �� ������ ������������ ������ �� ������������ ������� ������� �� ��� ������� ���������� ����������� ��������.',  now()::timestamp, 4, 2)
INSERT INTO drugstore_comment (id, comment, "date", drugstore_id, user_id) values(nextval ('drugstore_comment_id_seq'), '������-������ �� ���������� ������ � ������ ������� � ��������� ����� ������ ������. ����� �� ���� ����� ��� � ��������� ����� �� ������ ��������� �������� ��������� ������.',  now()::timestamp, 4, 4)
INSERT INTO drugstore_comment (id, comment, "date", drugstore_id, user_id) values(nextval ('drugstore_comment_id_seq'), '���� ���������� ���������� �� ����� ������ ��� ������� ��������, �������� ���������������� ����� �����.',  now()::timestamp, 4, 5)
INSERT INTO drugstore_comment (id, comment, "date", drugstore_id, user_id) values(nextval ('drugstore_comment_id_seq'), '������� ���� ��������� ������� ������� ������ �� ����� Lorem ipsum ������ ����� � ������� ��� ����������.',  now()::timestamp, 4, 6)
INSERT INTO drugstore_comment (id, comment, "date", drugstore_id, user_id) values(nextval ('drugstore_comment_id_seq'), '��������� ������ ���� ������ �� ���� ������ � ������������ �� ����� ������������ ���������. ��� ����������������� ������, � ������� �������� ����� ����������� �������� ����� � ���.',  now()::timestamp, 4, 7)
INSERT INTO drugstore_comment (id, comment, "date", drugstore_id, user_id) values(nextval ('drugstore_comment_id_seq'), '������� ������� ������������ �� � ���� �������, ����� ������ ������� � �������� ������ � �������, �� ����� �� ��� ����� ���� � �����.',  now()::timestamp, 4, 8)
INSERT INTO drugstore_comment (id, comment, "date", drugstore_id, user_id) values(nextval ('drugstore_comment_id_seq'), '�� ������ ���� ����� ��������� ����, ��������� ������� �� ���� � �������� � ������.',  now()::timestamp, 4, 9)
INSERT INTO drugstore_comment (id, comment, "date", drugstore_id, user_id) values(nextval ('drugstore_comment_id_seq'), '����������� �� ������ ������� ��������� ���, ������ �� ��������� ������ �����, �� ������ ������ ������� ������ ���������, �� ��������� ������� ������� � �� ������������ ������ �������� �������.',  now()::timestamp, 4, 10)
INSERT INTO drugstore_comment (id, comment, "date", drugstore_id, user_id) values(nextval ('drugstore_comment_id_seq'), '�������� ������������ ������ �������� �� ��� ���� � �� ��������� ���� ����.',  now()::timestamp, 4, 2)
INSERT INTO drugstore_comment (id, comment, "date", drugstore_id, user_id) values(nextval ('drugstore_comment_id_seq'), '�� ������ �������� ����� ��������. ��� ������������ ���: �� ���� ������ ��� �������������� �� ��������� ���.',  now()::timestamp, 4, 3)
INSERT INTO drugstore_comment (id, comment, "date", drugstore_id, user_id) values(nextval ('drugstore_comment_id_seq'), '������������, ��� �� ���� ��������, ��� ��������� ��.',  now()::timestamp, 4, 10)
INSERT INTO drugstore_comment (id, comment, "date", drugstore_id, user_id) values(nextval ('drugstore_comment_id_seq'), '����������� �� ����� � ���� ���������� ������.',  now()::timestamp, 4, 8)
INSERT INTO drugstore_comment (id, comment, "date", drugstore_id, user_id) values(nextval ('drugstore_comment_id_seq'), '�� ������������ ��������, ��� ����� ��������� ���� ����. ������ ��� ������������ �������� �����������',  now()::timestamp, 4, 7)





