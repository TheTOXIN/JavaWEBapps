INSERT INTO public.users (id, login, password) VALUES ('6e9c54de-c746-4f50-ba6a-03a176d61e71', 'toxin', '1998');
INSERT INTO public.users (id, login, password) VALUES ('c3425754-d7ac-44b8-a469-17d3dcacb204', 'admin', 'admin');
INSERT INTO public.users (id, login, password) VALUES ('824a7f61-d6cc-4b05-9de6-5a2750a149e2', 'artem', 'root');

INSERT INTO public.tasks (id, date, description, finished, title, user_id) VALUES ('6e4dfbfe-d43b-4f4f-a408-30a4ec3a596b', '2018-06-04', 'ТУСА ДЖУСА', false, 'День рождения', '6e9c54de-c746-4f50-ba6a-03a176d61e71');
INSERT INTO public.tasks (id, date, description, finished, title, user_id) VALUES ('6e4dfbfe-443b-4f4f-a408-30a4ec3a596b', '2018-06-03', 'Написать REST клиент', false, 'Angular', '6e9c54de-c746-4f50-ba6a-03a176d61e71');
INSERT INTO public.tasks (id, date, description, finished, title, user_id) VALUES ('72f9aac0-02d4-4b2a-ab6b-434e352420bf', '2018-06-06', 'подготовиться', false, 'ОГЭ', '824a7f61-d6cc-4b05-9de6-5a2750a149e2');
INSERT INTO public.tasks (id, date, description, finished, title, user_id) VALUES ('7e4dfbfe-443b-4f4f-a408-30a4ec3a596b', '2018-06-01', null, true, 'Глянуть мемы', '6e9c54de-c746-4f50-ba6a-03a176d61e71');
INSERT INTO public.tasks (id, date, description, finished, title, user_id) VALUES ('19c6aec5-9de0-42a3-9ea1-2525eaf93423', '2018-06-02', '', false, 'КАМПУТКЕР', '824a7f61-d6cc-4b05-9de6-5a2750a149e2');
INSERT INTO public.tasks (id, date, description, finished, title, user_id) VALUES ('560b5364-25cf-47fd-8b85-60ac93d5030d', '2018-06-10', '...', false, 'Админские дела', 'c3425754-d7ac-44b8-a469-17d3dcacb204');

