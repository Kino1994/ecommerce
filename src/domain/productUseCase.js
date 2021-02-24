function init({
  productRepository,
}) {

    async function getProducts() {
      return await productRepository.getProducts();
    }
  
    async function createProduct(productDto) {
      const product = {...productDto};
      return await productRepository.addProduct(product);
    }
  
    async function getProduct(id) {
      return await productRepository.getProduct(id);
    }
  
    async function deleteProduct(id) {
      const productDto = await this.findById(id);
      if (productDto) {
        await productRepository.delete(productDto)
        return productDto;
      }
      return false;
    }

    return {getProducts, createProduct, getProduct, deleteProduct};  
}

module.exports = {init};