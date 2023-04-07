alter table User add column account_non_expired character default 'S';
alter table User add column account_non_locked character default 'S';
alter table User add column credentials_non_expired character default 'S';
alter table User add column enabled character default 'S';

