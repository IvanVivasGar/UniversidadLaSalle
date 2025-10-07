// Servicio en memoria para productos con operaciones CRUD
const { faker } = require('@faker-js/faker');

class productsService {
    // Constructor: crea arreglo y lo llena con datos de ejemplo
    constructor(){
        this.products = [];
        this.generate();
    }

    // Genera productos de ejemplo usando faker
    generate(){
        const limit = 50;
        for (let index = 0; index < limit; index++) {
            this.products.push({
                id: faker.string.uuid(),
                name: faker.commerce.productName(),
                price: parseInt(faker.commerce.price(), 10),
                image: faker.image.url(),
                categoryId: faker.number.int({ min: 1, max: 10 }),
                brandId: faker.number.int({ min: 1, max: 10 }),
                stock: faker.number.int({ min: 0, max: 100 })
            });
        }
    }

    // Crea y agrega un producto
    create(data){
        const newProduct = {
            id: faker.string.uuid(),
            ...data
        };
        this.products.push(newProduct);
        return newProduct;
    }

    // Devuelve todos los productos
    getAll(){
        return this.products;
    }

    // Busca un producto por id
    getById(id){
        return this.products.find(item => item.id === id) || null;
    }

    // Actualiza un producto existente
    update(id, changes){
        const index = this.products.findIndex(item => item.id == id);
        if (index === -1){
            return null;
        }
        const product = this.products[index];
        this.products[index] = {
            ...product,
            ...changes,
            id
        };
        return this.products[index];
    }

    // Elimina un producto por id
    delete(id){
        const index = this.products.findIndex(item => item.id == id);
        if (index === -1){
            return null;
        }
        const deleted = this.products.splice(index, 1)[0];
        return deleted;
    }
}

module.exports = productsService;