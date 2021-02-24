const {Product} = require('./model/product.js');

function init({
  productRepository,
}) {

    function productEntityToProduct(product) {
      return {
        id: product.id,
        name: product.name,
        description: product.description,
        price: product.value
      }
    }

    async function getProducts() {
      const products = await Product.find();
      return products.map(productEntityToProduct);
    }

    async function createProduct(product) {
      const productEntity = new Product(product);
      await productEntity.save();
      return productEntityToProduct(productEntity);
    }

    async function getProduct(id) {
      const productEntity = await Product.findById(id);
      if (productEntity) {
        return productEntityToProduct(productEntity);
      }
      return false;
    }

    async function deleteProduct(product) {
      const productEntity = await Product.findById(product.id);
      await productEntity.delete();
    }
    return {getProducts, createProduct, getProduct, deleteProduct};
  }

module.exports = init