const { Sequelize, Model, DataTypes } = require('sequelize');
const { sequelize } = require('../../database.js')

class Product extends Model { }

const product = Product.init({
    name: DataTypes.STRING,
    description: DataTypes.STRING,
    value: DataTypes.DOUBLE,
    autoIncrement: true
}, { sequelize, modelName: 'product' });

module.exports = { Product }