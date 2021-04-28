const path = require('path')

const HtmlWebpackPlugin = require('html-webpack-plugin')
const { CleanWebpackPlugin } = require('clean-webpack-plugin')
const CopyWebpackPlugin = require('copy-webpack-plugin')
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const OptimizeCssAssetsPlugin = require('optimize-css-assets-webpack-plugin')
const TerserPlugin = require('terser-webpack-plugin')

const isDev = process.env.NODE_MODE === 'development'

const getFileName = (ext) => {
    let filename;
    if (isDev) {
        filename = `[name].${ext}`
    } else {
        filename = `[name].[hash].${ext}`
    }
    return filename
}

const optimize = () => {
    const config = {
        splitChunks: {
            chunks: 'all'
        }
    }

    if (!isDev) {
        config.minimizer = [
            new OptimizeCssAssetsPlugin(),
            new TerserPlugin()]
    }
    return config
}

module.exports = {
    context: path.resolve(__dirname, 'src'),
    entry: {
        main: './index.jsx'
    },

    output: {
        filename: getFileName('js'),
        path: path.resolve(__dirname, 'dist')
    },

    optimization: optimize(),
    devtool: isDev ? 'source-map' : false,
    
    plugins: [
        new HtmlWebpackPlugin({
            template: './index.html',
            favicon: './assets/favicon.ico',
        }),
        new CleanWebpackPlugin(),
        new MiniCssExtractPlugin({
            filename: getFileName('css')
        })
    ],
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
                    MiniCssExtractPlugin.loader,
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
                    MiniCssExtractPlugin.loader,
                    "css-loader"
                ],
            },
            {
                test: /\.tsx?$/,
                use: 'ts-loader',
                exclude: /node_modules/,
            },
            {
                test: /\.(svg|png|jpg|gif)$/,
                loader: 'file-loader'
            }
        ]
    },
    devServer: {
        historyApiFallback: true,
        contentBase: path.relative(__dirname, 'dist'),
        port: 9000,
        hot: isDev
    }
};