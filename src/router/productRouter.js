const express = require('express');

const routes = express.Router();

function init({
  productService,
}) {

  routes.get('api/products', async function (req, res) {
    console.log("LOL");
    const productResponse = productService.getProducts();
    return res.json(productResponse);
  });

  routes.post('api/products', async function (req, res){
    console.log("LOL");
    const productResponse = productService.createProduct({
      name: req.body.name,
      description: req.body.description,
      value: req.body.value
    });
    return res.status(201).json(productResponse);
  });

  routes.get('/api/products/:id', async function (req, res){
    const productResponse = productService.getProduct(req.params.id);
    if (productResponse) {
      return res.json(productResponse);
    }
    return res.status(404).send('Product not found');
  });

  routes.delete('/api/products/:id', async function (req, res){
    const productResponse = productService.deleteProduct(req.params.id);
    if (productResponse) {
      return res.json(productResponse);
    }
    return res.status(404).send('Product not found');
  });

  return {init,routes};

}

module.exports = {init};