function init({
  productUseCase
}) {

    async function getProducts() {
      return await productUseCase.getProducts();
    }
  
    async function createProduct(productResponse) {
      return await productUseCase.createProduct({productResponse});
    }
  
    async function getProduct(id) {
      return await productUseCase.getProduct(id);
    }
  
    async function deleteProduct(id) {
      return await productUseCase.deleteProduct(id);
    }

    return {getProducts, createProduct, getProduct, deleteProduct};
  
}

module.exports = {init};