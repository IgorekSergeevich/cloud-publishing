
//const MiniCssExtractPlugin = require('mini-css-extract-plugin');

module.exports = {
    entry: "./src/app.jsx",
    output: {
        path: __dirname + "/dist",
        filename: "index.js"     
    },
    //plugins: [new MiniCssExtractPlugin({filename : "style.css"})],
    module: {
        rules: [
            {
                test: /\.jsx$|\.js$/,
                exclude: "/node_modules/",
                loader: "babel-loader"
            },
            {
                test: /\.module\.css$/,
                exclude: /node_modules/,
                use: [       
                    //MiniCssExtractPlugin.loader,
                    "style-loader",
                    {
                        loader: "css-loader",
                        options: {
                            modules: true
                        }
                    }
                ],
            },
            {
                test: /\.css$/,
                exclude: /node_modules|\.module\.css$/,
                use: [
                    //MiniCssExtractPlugin.loader,       
                    "style-loader",
                    "css-loader"
                ],
            }
        ]
    },
    devServer: {
        historyApiFallback: true,
        contentBase: __dirname + "/dist",
        port: 9000,
        publicPath: "/script",
        watchContentBase: true
    }
};