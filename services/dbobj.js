const db = require('./postdb');
const config = require('../config');

async function getTable()
{
    const out = await db.query(
        'SELECT * FROM tptable;'
    );

    return {
        out
    }
}

module.exports = {
    getTable
}