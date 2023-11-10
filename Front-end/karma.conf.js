// Karma configuration
// Generated on Wed Nov 08 2023 12:42:00 GMT+0100 (GMT+01:00)

module.exports = function (config) {
  config.set({

    // base path that will be used to resolve all patterns (eg. files, exclude)
    basePath: '',


    // frameworks to use
    // available frameworks: https://www.npmjs.com/search?q=keywords:karma-adapter
    frameworks: ['jasmine'],


    // list of files / patterns to load in the browser
    files: [
      'src/app/**/*.ts',
      'src/app/**/*.spec.ts',
      'src/app/admin/**/*.ts',
      'src/app/admin/**/*.spec.ts',
      'src/app/admin/**/**/*.ts',
      'src/app/admin/**/**/*.spec.ts',
      'src/app/admin/dvd/dvd-list/admin-dvd-list.component.ts',
      'src/app/admin/dvd/dvd-list/admin-dvd-list.component.spec.ts'
    ],


    // list of files / patterns to exclude
    exclude: [],


    // preprocess matching files before serving them to the browser
    // available preprocessors: https://www.npmjs.com/search?q=keywords:karma-preprocessor
    preprocessors: {
      'src/app/**/*.ts': ['typescript'],
      'src/app/**/*.spec.ts': ['typescript'],
      'src/app/admin/**/*.ts': ['typescript'],
      'src/app/admin/**/*.spec.ts': ['typescript'],
      'src/app/admin/**/**/*.ts': ['typescript'],
      'src/app/admin/**/**/*.spec.ts': ['typescript']
    },


    // test results reporter to use
    // possible values: 'dots', 'progress'
    // available reporters: https://www.npmjs.com/search?q=keywords:karma-reporter
    reporters: ['progress'],


    // web server port
    port: 9876,


    // enable / disable colors in the output (reporters and logs)
    colors: true,


    // level of logging
    // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
    logLevel: config.LOG_INFO,


    // enable / disable watching file and executing tests whenever any file changes
    autoWatch: true,


    // start these browsers
    // available browser launchers: https://www.npmjs.com/search?q=keywords:karma-launcher
    browsers: ['Chrome'],


    // Continuous Integration mode
    // if true, Karma captures browsers, runs the tests and exits
    singleRun: false,

    // Concurrency level
    // how many browser instances should be started simultaneously
    concurrency: Infinity
  })
}
