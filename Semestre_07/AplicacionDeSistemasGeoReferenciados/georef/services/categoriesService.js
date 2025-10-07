// Servicio en memoria para categorías (genera datos con Faker)
(function(){
const { faker } = require('@faker-js/faker');

class categoriesService {
	// Constructor y generación inicial
	constructor(){
		this.categories = [];
		this.generate();
	}

	// Genera categorías de ejemplo
	generate(){
		const limit = 10;
		for (let i = 0; i < limit; i++) {
			this.categories.push({
				id: i + 1,
				categoryName: faker.commerce.department(),
				description: faker.lorem.sentence(),
				active: faker.datatype.boolean()
			});
		}
	}

	// Crea y agrega una categoría
	create(data){
		const id = this.categories.length ? this.categories[this.categories.length - 1].id + 1 : 1;
		const newCategory = { id, ...data };
		this.categories.push(newCategory);
		return newCategory;
	}

	// Devuelve todas las categorías
	getAll(){
		return this.categories;
	}

	// Devuelve una categoría por id
	getById(id){
		const categoryId = Number(id);
		return this.categories.find(c => c.id === categoryId) || null;
	}

	// Actualiza una categoría existente
	update(id, changes){
		const categoryId = Number(id);
		const index = this.categories.findIndex(c => c.id === categoryId);
		if (index === -1) return null;
		this.categories[index] = { ...this.categories[index], ...changes, id: categoryId };
		return this.categories[index];
	}

	// Elimina una categoría
	delete(id){
		const categoryId = Number(id);
		const index = this.categories.findIndex(c => c.id === categoryId);
		if (index === -1) return null;
		const deleted = this.categories.splice(index, 1)[0];
		return deleted;
	}
}

module.exports = categoriesService;
})();

