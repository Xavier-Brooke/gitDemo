const path = require('node:path') ;
const express = require("express") ;
const { faker } = require("@faker-js/faker") ;
const methodOverride = require("method-override") ;

let data = require("../data/faker") ;

const app = express() ;

app.set("view engine", "ejs") ;
app.set("views", path.join(__dirname, '../views')) ;

app.use(express.json()) ;
app.use(methodOverride("_method")) ;
app.use(express.urlencoded({extended:true})) ;
app.use(express.static(path.join(__dirname, '../public'))) ;

// root
app.get("/", (req, res) => {
    let length = data.length ;
    res.render('root.ejs', { length }) ;
})

// home
app.get("/api", (req, res) => {
    let users = data ;
    res.render('home.ejs', { users }) ;
})

// new chat
app.get("/api/newChat", (req, res) => {
    res.render('newChat.ejs') ;
})

// collecting data from '/api/newChat'
app.post('/api', (req, res) => {
    console.log(req.body) ;
    res.send("working..") 
})

// details
app.get('/api/:id/details', (req, res) => {
    let { id } = req.params ;
    let userData = data.filter(users => users.id === id) ;
    let user = userData[0] ;
    res.render('details.ejs', { user }) ;
})

// edit
app.get('/api/:id/edit', (req, res) => {
    let { id } = req.params ;
    let userData = data.filter(user => user.id === id) ;
    if(userData.length > 0) {
        return res.render('edit.ejs', { user: userData[0] }) ;
    }
    return res.render('Errors/userNotFound') ;
})

// collecting data from '/api/:id/edit'
app.post('/api/:id', (req, res) => {
    let { id } = req.params ;
    let { name, msg } = req.body ;
    console.log(req.body) ;
    res.send("working..") ;
})

// delete route
app.delete('/api/:id/delete', (req, res) => {
    let { id } = req.params ;
    data = data.filter(user => user.id !== id) ;
    res.redirect('/api') ;
})

app.listen(8000, () => {
    console.log(`App is listening at port 8000`) ;
})