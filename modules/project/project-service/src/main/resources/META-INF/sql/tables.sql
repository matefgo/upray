create table Project_Project (
	uuid_ VARCHAR(75) null,
	projectId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	customerId LONG,
	name VARCHAR(75) null,
	originalVersion VARCHAR(75) null,
	upgradeVersion VARCHAR(75) null,
	status INTEGER,
	phase INTEGER,
	deadline DATE null,
	deliveryDate DATE null,
	contractDate DATE null
);