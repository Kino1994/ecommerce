const productService = ({productUseCase}) => ({

    async getProducts() {
      return await productUseCase.findAll();
    },
  
    async createProduct(productResponse) {
      return await productUseCase.createProduct({productResponse});
    },
  
    async getProduct(id) {
      return await productUseCase.getProduct(id);
    },
  
    async deleteProduct(id) {
      return await productUseCase.deleteProduct(id);
    },
  
});

module.exports = productService;