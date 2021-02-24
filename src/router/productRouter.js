const express = require('express');

const router = express.Router();

const productRouter = ({productService}) => {
  
  router.get('/api/products', async function (req, res) {
    const productResponse = await productService.getProducts();
    return res.json(productResponse);
  });

  router.post('/api/products', async function (req, res) {
    const productResponse = await productService.createProduct({
      name: req.body.name,
      description: req.body.description,
      value: req.body.value
    });
    return res.status(201).json(productResponse);
  });

  router.get('/api/products/:id', async function (req, res) {
    const productResponse = await productService.getProduct(req.params.id);
    if (productResponse) {
      return res.json(productResponse);
    }
    return res.status(404).send('Product not found');
  });

  router.delete('/api/products/:id', async function (req, res) {
    const productResponse = await productService.deleteProduct(req.params.id);
    if (productResponseDto) {
      return res.json(productResponseDto);
    }
    return res.status(404).send('Product not found');
  });

  return routes;
}

module.exports = {productRouter};