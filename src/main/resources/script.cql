create (_001:Person { name :'Dolar Akar'})
create (_002:Person { name :'Yılmaz Yılmaz'})
create (_003:Person { name :'Bermat Apayrak'})
create (_004:Person { name :'Sedef Medef'})
create (_005:Person { name :'Ceren Meren'})
create (_006:Person { name :'Ayse Fatma'})
create (_007:Person { name :'Sema Mema'})
create (_008:Person { name :'Alexander Reyizov'})
create (_009:Person { name :'Alexander Konstantinos'})
create (_008)-[:FATHER]->(_004)
create (_008)-[:FATHER]->(_005)
create (_009)-[:FATHER]->(_006)

create (mer:Brand {name : 'Mercedes'})
create (aud:Brand {name : 'Audi'})
create (bent:Brand {name : 'Bentley'})
create (bmw:Brand {name : 'BMW'})
create (hond:Brand {name : 'Honda'})



create (car1:Car {name : 'Civic', year: 1998})
create (car2:Car {name : 'CLA', year: 2010})

create (_004)-[:HAS]->(car1)
create (_005)-[:HAS]->(car2)

create (mer)-[:MANUFACTURES]->(car2)
create (hond)-[:MANUFACTURES]->(car1)


create (C1:Country { name :'Turmanya'})
create (C2:Country { name :'Evmanya'})

create (_008)-[:PRIME_MINISTER_OF]->(C1)
create (_009)-[:PRIME_MINISTER_OF]->(C2)