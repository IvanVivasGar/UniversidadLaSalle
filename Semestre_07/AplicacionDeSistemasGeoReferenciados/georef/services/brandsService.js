// Servicio en memoria para marcas (genera datos con Faker)
(function(){
const { faker } = require('@faker-js/faker');

class brandsService {
	// Constructor y generación inicial
	constructor(){
		this.brands = [];
		this.generate();
	}

	// Genera marcas de ejemplo
	generate(){
		const limit = 10;
		for (let i = 0; i < limit; i++) {
			this.brands.push({
				id: i + 1,
				brandName: faker.company.name(),
				description: faker.lorem.sentence(),
				active: faker.datatype.boolean()
			});
		}
	}

	// Crea y agrega una marca
	create(data){
		const id = this.brands.length ? this.brands[this.brands.length - 1].id + 1 : 1;
		const newBrand = { id, ...data };
		this.brands.push(newBrand);
		return newBrand;
	}

	// Devuelve todas las marcas
	getAll(){
		return this.brands;
	}

	// Devuelve una marca por id
	getById(id){
		const brandId = Number(id);
		return this.brands.find(b => b.id === brandId) || null;
	}

	// Actualiza una marca existente
	update(id, changes){
		const brandId = Number(id);
		const index = this.brands.findIndex(b => b.id === brandId);
		if (index === -1) return null;
		this.brands[index] = { ...this.brands[index], ...changes, id: brandId };
		return this.brands[index];
	}

	// Elimina una marca
	delete(id){
		const brandId = Number(id);
		const index = this.brands.findIndex(b => b.id === brandId);
		if (index === -1) return null;
		const deleted = this.brands.splice(index, 1)[0];
		return deleted;
	}
}

module.exports = brandsService;
})();

