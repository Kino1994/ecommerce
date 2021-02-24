import {Product} from "./models/Product.js";

const productRepository = ({}) => ({
  
  async getProducts() {
    return Product.getProducts();
  },

  async createProduct(product) {
    const productEntityDto = new ProductEntity(product);
    return productEntityDto.createProduct();
  },

  async getProduct(id) {
    const productEntityDto = await Product.getProduct(id);
    if (productEntityDto) {
      return productEntityDto;
    }
    return false;
  },

  async deleteProduct(product) {
    const productEntityDto = await ProductEntity.findById(product.id);
    await productEntityDto.deleteProduct();
  },

});

module.exports = productRepository;