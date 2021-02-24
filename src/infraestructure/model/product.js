const { sequelize, Model, DataTypes  } = require('../../database.js')

class Product extends Model { }

Product.init({
    id: {
        type: DataTypes.INTEGER,
        primaryKey: true,
        autoIncrement: true
    },
    name: DataTypes.STRING,
    description: DataTypes.STRING,
    value: DataTypes.DOUBLE,
}, { sequelize, modelName: 'product' });

module.exports = { Product }