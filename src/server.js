const express = require('express');
const { sequelize } = require('./database.js');
const productRouter = require("./router/productRouter.js");
const app = express();

app.use(express.json());

app.listen(8080, () => {
    //app.use('/', productRouter.router);
    //app.use('/', ShoppingCartRouter);
    sequelize.sync();
    console.log('Example app listening on port 8080!');
    console.log("Connected to MySQL");   
});