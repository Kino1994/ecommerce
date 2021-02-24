const express = require('express');
const { sequelize } = require('./database.js');
const app = express();
const productRouter = require('./router/productRouter.js');
const productService = require('./service/productService.js');
const productUseCase = require('./domain/productUseCase.js');
const productRepository = require('./infraestructure/productRepository.js');


app.use(express.json());

app.listen(8080, () => {
    const useCase = productUseCase.init(productRepository);
    const service = productService.init(useCase);
    const {routes} = productRouter.init(service);

    
    app.use('/',routes);
    sequelize.sync();
    console.log('App listening on port 8080!');
    console.log("Connected to MySQL");   
});