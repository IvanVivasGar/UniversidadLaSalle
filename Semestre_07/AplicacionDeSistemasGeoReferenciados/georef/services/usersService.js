// Servicio en memoria para usuarios (genera datos con Faker)
(function(){
const { faker } = require('@faker-js/faker');

class usersService {
	// Constructor: arreglo en memoria y generación inicial
	constructor(){
		this.users = [];
		this.generate();
	}

	// Genera usuarios falsos para pruebas
	generate(){
		const limit = 10;
		for (let i = 0; i < limit; i++) {
			this.users.push({
				id: i + 1,
				name: faker.person.fullName(),
				username: faker.internet.userName(),
				password: faker.internet.password()
			});
		}
	}

	// Crea y agrega un usuario
	create(data){
		const id = this.users.length ? this.users[this.users.length - 1].id + 1 : 1;
		const newUser = { id, ...data };
		this.users.push(newUser);
		return newUser;
	}

	// Devuelve todos los usuarios
	getAll(){
		return this.users;
	}

	// Devuelve un usuario por id o null
	getById(id){
		const userId = Number(id);
		return this.users.find(u => u.id === userId) || null;
	}

	// Actualiza un usuario existente
	update(id, changes){
		const userId = Number(id);
		const index = this.users.findIndex(u => u.id === userId);
		if (index === -1) return null;
		this.users[index] = { ...this.users[index], ...changes, id: userId };
		return this.users[index];
	}

	// Elimina un usuario por id
	delete(id){
		const userId = Number(id);
		const index = this.users.findIndex(u => u.id === userId);
		if (index === -1) return null;
		const deleted = this.users.splice(index, 1)[0];
		return deleted;
	}
}

module.exports = usersService;
})();