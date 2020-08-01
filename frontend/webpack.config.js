
//const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const CopyPlugin = require('copy-webpack-plugin');

module.exports = {
    devtool: 'source-map',
    entry: "./src/index.jsx",
    output: {
        path: __dirname + "/dist",
        filename: "index.js",
        publicPath: "/public"
    },
    plugins: [
        new CopyPlugin({
            patterns: [
                { from: 'public' },
            ]
        }),
    ],
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
            },
            {
                test: /\.tsx?$/,
                use: 'ts-loader',
                exclude: /node_modules/,
            },
            {
                test: /\.svg$/,
                loader: 'svg-url-loader'
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