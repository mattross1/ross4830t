const gulp = require('gulp');
const war = require('gulp-war');
const zip = require('gulp-zip');

function defaultTask(cb) {
    
    
    cb();
}

gulp.task('war', async function () {
    gulp.src(["*.js", "*.md", "test/*.js"])
        .pipe(war({
            welcome: 'index.html',
            displayName: 'Grunt WAR',
        }))
        .pipe(zip('techp.war'))
        .pipe(gulp.dest("./dist"));
 
});


exports.default = defaultTask