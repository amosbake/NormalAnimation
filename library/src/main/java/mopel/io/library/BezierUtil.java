package mopel.io.library;

/**
 * Author: mopel
 * Date : 2017/4/23
 */

public class BezierUtil {
  /**
   * B(t) = (1 - t)^2 * P0 + 2t * (1 - t) * P1 + t^2 * P2, t ∈ [0,1]
   *
   * @param t  曲线长度比例
   * @param p0 起始点
   * @param p1 控制点
   * @param p2 终止点
   * @return t对应的点
   */
  public static float CalculateBezierValueForQuadratic(float t, float p0, float p1, float p2) {
    float temp = 1 - t;
    return temp * temp * p0 + 2 * t * temp * p1 + t * t * p2;
  }

  /**
   * B(t) = P0 * (1-t)^3 + 3 * P1 * t * (1-t)^2 + 3 * P2 * t^2 * (1-t) + P3 * t^3, t ∈ [0,1]
   *
   * @param t  曲线长度比例
   * @param p0 起始点
   * @param p1 控制点1
   * @param p2 控制点2
   * @param p3 终止点
   * @return t对应的点
   */
  public static float CalculateBezierValueForCubic(float t, float p0, float p1, float p2, float p3) {
    float temp = 1 - t;
    return p0 * temp * temp * temp + 3 * p1 * t * temp * temp + 3 * p2 * t * t * temp + p3 * t * t * t;
  }
}
