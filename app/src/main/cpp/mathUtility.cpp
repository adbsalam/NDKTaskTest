
// Created by Muhammad on 2019-10-18.

#include <jni.h>
#include <string>

//addition
extern "C"
JNIEXPORT jint JNICALL
Java_com_salam_ndktasktest_MainActivity_sumOfNumbers(JNIEnv *env, jobject instance, jint a,
                                                     jint b) {
    return (a + b);
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_salam_ndktasktest_MainActivity_subtractionOfNumbers(JNIEnv *env, jobject instance, jint a,
                                                             jint b) {
    return (a - b);
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_salam_ndktasktest_MainActivity_multiplicationOfNumbers(JNIEnv *env, jobject instance,
                                                                jint a, jint b) {
    return (a * b);
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_salam_ndktasktest_MainActivity_divideNumbers(JNIEnv *env, jobject instance, jint a,
                                                      jint b) {

    return (a/b);

}