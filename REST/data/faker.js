const { faker } = require('@faker-js/faker') ;

function getData() {
    return {
        id : faker.string.uuid(),
        name : faker.person.fullName(),
        msg : faker.lorem.lines({ min:2, max:5}),
        sent_at : faker.date.anytime()
    }
}

let data = [] ;

/**
 * this will generate fake data
 * @param {number} n number of fake data should be generated
 */
function fakeData(n=10) {
    for(let i = 0; i < n; i++) {
        data.push(getData()) ;
    }
}

fakeData() ;

module.exports = data ;