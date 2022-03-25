const express = require('express')
const router = express.Router()
const dbobj = require('./services/dbobj')


router.use((req, res, next) => {
    next()
})

router.get('/', async function(req, res) {
    try {
        res.json(await dbobj.getTable());
    } catch(err) {
        res.send(err.message)
    }
    
})

module.exports = router