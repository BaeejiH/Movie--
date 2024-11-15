const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})


// 프론트의 proxy 와 백엔드의 CrossOrigin 두개로 데이터 전송이 가능함.
// 프론트의 proxy는 한개 , 이를 해결하가 위해 백엔드에서 CrossOrigin으로 관리하는게 편리함.

//ex) CrossOrigin
// app.use(
//   cors({
//     origin: 'http://localhost:8800',
//     methods: ['GET', 'POST'],
//     allowedHeaders: ['Content-Type', 'Authorization'],
//   })
// );

//ex) proxy
// const target = 'http://localhost:8080/'
// module.exports = {
//   devServer:{
//     port:8080,
//     proxy:{
//       '/api':{
//         target,
//         changeOrigin: true
//       }
//     }
//   }
// }