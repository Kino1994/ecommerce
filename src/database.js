const { Sequelize, Model, DataTypes } = require('sequelize');

const sequelize = new Sequelize('test', 'root', 'password', {
        dialect: 'mysql'
});

module.exports = { sequelize, Model, DataTypes }