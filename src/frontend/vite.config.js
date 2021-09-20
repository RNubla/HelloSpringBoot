import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  server: {
    port: 3000,
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        ws: true,
        changeOrigin: true
      }
    }
  }
})
/*Any route that goes to '/api' will automatically be forwarded to locahost:8080 */
// export default {
//   plugins: [vue()],
//   devServer: {
//     port: 3000,
//     proxy: {
//       '/api': {
//         target: 'http://localhost:8080',
//         ws: true,
//         changeOrigin: true,
//         secure:false
//       }
//     }
//   }
// }