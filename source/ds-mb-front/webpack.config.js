const path = require('path');

module.exports = {
  mode: 'development',
  entry: './src/index.jsx',
  output: {
    filename: 'index_bundle.js',
    path: path.resolve(__dirname, 'src')
  },
  // 設定 bable loader 來編譯 js 和 jsx 程式碼
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /node_modules/,
        use: {
          loader: 'babel-loader',
          // 可以使用下面這段來取代 .babelrc 設定檔
          options: {
            presets: ['@babel/preset-env', '@babel/preset-react']
          }
        }
      },
      {
        test: /\.css$/,
        use: ['style-loader', 'css-loader']
      }
    ]
  },
  // 設定後可以透過 npx webpack-dev-server 啟動一個簡單的 server 來做測試
  devServer: {
    port: 9000
  }
};
