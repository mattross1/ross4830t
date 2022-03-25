const express = require('express')
const app = express()
const port = 3000
const router = require("./exroute")

app.use(express.json())
app.use(
    express.urlencoded({
      extended: true,
    })
  );

app.get('/', (req, res) => {
  res.json({message: 'testing'});
})

app.use("/express", router);

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})